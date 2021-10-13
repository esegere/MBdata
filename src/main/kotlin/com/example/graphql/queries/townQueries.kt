package com.example.graphql.queries

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.domain.Town
import com.example.repository.influx.InfluxDB

fun SchemaBuilder.townQueries() {

    query("towns") { // get lis of all available units
        resolver { ->
            InfluxDB.positions.listTowns()
        }
    }

    query("unitsByTown") {
        resolver { town: Town ->
            InfluxDB.units.getUnits().filter {
                it.positions.last().town == town
            }
        }
    }
}