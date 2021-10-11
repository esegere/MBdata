package com.example.graphql

import com.apurebase.kgraphql.GraphQL
import com.example.graphql.queries.unitQueries
import java.util.*

fun GraphQL.Configuration.configureSchema() {

    schema {

        // include datatypes in schema
        type<MBUnit> {
            name = "Unit"
            property<List<Position>>("positions") {
                resolver { mbUnit: MBUnit ->
                    listOf(
                        Position(Date().toString(), Town.AZCAPOTZALCO)
                    )
                }
            }
        }
        enum<Town>()

        // add extension functions with related operations in this section
        unitQueries()
    }
}