package com.example.repository.database

import com.example.domain.Position
import com.example.repository.PositionDAO
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime


class SQLitePositionDAO : PositionDAO {

    override fun getPositions(): List<Position> = transaction {
        Positions.selectAll().map {
            Position(
                it[Positions.town],
                it[Positions.date].toString()
            )
        }
    }

    override fun getPositionByUnitID(id: Int): List<Position> = transaction {//most recent positions are shown first
        Positions.select {
            Positions.unitId eq id
        }.orderBy(Positions.date, SortOrder.DESC)
            .map {
                Position(
                    it[Positions.town],
                    it[Positions.date].toString()
                )
            }
    }

    override fun addPositionForUnitID(id: Int, position: Position): Unit = transaction {
        val foundId = Units.select { // get row for id
            Units.vehicleId eq id
        }.firstOrNull()?.let {
            it[Units.id]
        } ?: return@transaction //if vehicle id does not exist exit, nothing else to do

        val found = Positions.selectAll().any {
            it[Positions.date].toString() == position.date &&
                    it[Positions.unitId] == foundId
        }
        if (found) return@transaction
        Positions.insert {
            it[Positions.unitId] = foundId
            it[Positions.town] = position.town
            it[Positions.date] = LocalDateTime.parse(position.date)
        }
    }
}