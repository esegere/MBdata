package com.example

import com.example.plugins.configureGraphQL
import com.example.plugins.configureLogging
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080 // hardcoded value for default port

    embeddedServer(
        Netty,
        port = port,
        host = "0.0.0.0"
    ) {
        configureRouting()
        configureGraphQL()
        configureSerialization()
        configureLogging()
    }.start(wait = true)
}
