package com.example.plugins

import com.apurebase.kgraphql.GraphQL
import com.example.graphql.configureSchema
import io.ktor.application.*

fun Application.configureGraphQL() { // 
    install(GraphQL) {
        playground = true
        endpoint = "graphql"
        configureSchema()
    }
}