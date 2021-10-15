package com.example.repository.database

import com.example.domain.Position
import com.example.repository.PositionDAO
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


class SqlitePositionDAO() : PositionDAO {

    override fun getPositions(): List<Position> = transaction {
        Positions.selectAll().map {
            Position(
                it[Positions.town],
                it[Positions.date].toString()
            )
        }
    }

    override fun getPositionByUnitID(id: Int): List<Position> = transaction {
        Positions.select {
            Positions.unitId eq id
        }.map {
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