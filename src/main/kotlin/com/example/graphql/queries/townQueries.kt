package com.example.graphql.queries

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.domain.Town
import com.example.repository.database.SQLiteMBUnitDAO
import com.example.repository.database.SqlitePositionDAO

fun SchemaBuilder.townQueries() {

    val positionDAO = SqlitePositionDAO()
    val unitsDAO = SQLiteMBUnitDAO(positionDAO)

    query("towns") { // get list of all available units
        resolver { ->
            positionDAO.listTowns()
        }
    }

    query("unitsByTown") {
        resolver { town: Town ->
            unitsDAO.getUnits().filter {
                it.positions.last().town == town
            }
        }
    }
}