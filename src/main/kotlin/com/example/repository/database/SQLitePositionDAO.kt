package com.example.repository.database

import com.example.domain.Position
import com.example.repository.PositionDAO
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


class SQLitePositionDAO() : PositionDAO {

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

    override fun addPositionForUnitID(id: Int, position: Position) {
        TODO("Not yet implemented")
    }
}