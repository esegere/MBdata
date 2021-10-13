package com.example.graphql

import com.apurebase.kgraphql.GraphQL
import com.example.domain.Town
import com.example.graphql.queries.townQueries
import com.example.graphql.queries.unitQueries

fun GraphQL.Configuration.configureSchema() {

    schema {

        // include datatypes in schema
        type<MBUnit> {
            name = "Unit"
        }
        enum<Town>()

        // add extension functions with related operations in this section
        unitQueries()
        townQueries()
    }
}