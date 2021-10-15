package com.example.graphql.queries

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.domain.Town
import com.example.repository.database.SQLiteMBUnitDAO
import com.example.repository.database.SQLitePositionDAO

fun SchemaBuilder.townQueries() {

    val positionDAO = SQLitePositionDAO()
    val unitsDAO = SQLiteMBUnitDAO(positionDAO)

    query("towns") { // get list of all available units
        resolver { ->
            positionDAO.listTowns()
        }
    }

    query("unitsByTown") {
        resolver { town: Town ->
            val res = unitsDAO.getUnits().filter {
                it.positions.firstOrNull()?.town.let { // prevent from throwing exception
                    it == town
                } ?: false//most recent positions are shown first
            }
            println(res.size)
            return@resolver res
        }
    }
}