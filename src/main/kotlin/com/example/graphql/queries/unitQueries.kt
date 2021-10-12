package com.example.graphql.queries

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.graphql.MBUnit

fun SchemaBuilder.unitQueries () {
    query("units") { // get lis of all available units
        resolver { ->
            listOf(
                MBUnit(1),
                MBUnit(2),
                MBUnit(3),
            )
        }
    }

    query("unit") {
        resolver { id: Int ->
            MBUnit(id)
        }
    }
}