package com.example

import com.example.plugins.configureGraphQL
import com.example.plugins.configureLogging
import com.example.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureGraphQL()
        configureSerialization()
        configureLogging()
    }.start(wait = true)
}
