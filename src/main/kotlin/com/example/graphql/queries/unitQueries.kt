package com.example.graphql.queries

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.repository.database.SQLiteMBUnitDAO
import com.example.repository.database.SQLitePositionDAO


fun SchemaBuilder.unitQueries() {

    val positionDAO = SQLitePositionDAO()
    val unitsDAO = SQLiteMBUnitDAO(positionDAO)

    query("units") { // get lis of all available units
        resolver { ->
            unitsDAO.getUnits()
        }
    }

    query("unit") {
        resolver { id: Int ->
            unitsDAO.getUnitByVehicleId(id)
        }
    }
}