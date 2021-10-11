package com.example.graphql.queries

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.graphql.MBUnit
import com.example.graphql.Position
import com.example.graphql.Town
import java.util.*

fun SchemaBuilder.unitQueries () {
    query("units") { // get lis of all available units
        resolver { page: Int? ->
            listOf(
                MBUnit(1, listOf(Position(Date().toString(), Town.AZCAPOTZALCO))),
                MBUnit(2, listOf(Position(Date().toString(), Town.ALVARO_OBREGON))),
                MBUnit(3, listOf(Position(Date().toString(), Town.AZCAPOTZALCO))),
            )
        }
    }

    query("unit") {
        resolver { id: Int ->
            MBUnit(id, listOf(Position(Date().toString(), Town.ALVARO_OBREGON)))
        }
    }
}