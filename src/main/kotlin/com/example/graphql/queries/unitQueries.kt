package com.example.graphql.queries

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.repository.influx.InfluxDB

fun SchemaBuilder.unitQueries () {

    query("units") { // get lis of all available units
        resolver { ->
            InfluxDB.units.getUnits()
        }
    }

    query("unit") {
        resolver { id: Int ->
            InfluxDB.units.getUnitById(id)
        }
    }
}