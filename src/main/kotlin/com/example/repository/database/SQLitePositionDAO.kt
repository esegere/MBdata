package com.example.repository.database

import com.example.domain.Position
import com.example.repository.PositionDAO
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class SQLitePositionDAO : PositionDAO {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ss") // the format that is received from API

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
        val found = Positions.selectAll().any {
            it[Positions.date].toString() == position.date &&
                    it[Positions.unitId] == id
        }
        if (found) return@transaction
        Positions.insert {
            it[Positions.unitId] = id
            it[Positions.town] = position.town
            it[Positions.date] = LocalDateTime.parse(position.date, formatter)
        }
    }
}