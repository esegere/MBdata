package com.example.plugins

import com.apurebase.kgraphql.GraphQL
import com.apurebase.kgraphql.GraphQLError
import io.ktor.application.*


fun Application.configureGraphQL() {
    install(GraphQL) {
        playground = true
        schema {
            query("hello") {
                resolver { -> "World" }
            }
        }
    }
}