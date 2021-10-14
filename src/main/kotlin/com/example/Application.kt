package com.example


import com.example.ingest.retrieveAPIInfo
import com.example.plugins.configureGraphQL
import com.example.plugins.configureLogging
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080 // hardcoded value for default port
    async(Dispatchers.IO) { // in order to perform concurrent IO

        launch { //launch client
            retrieveAPIInfo()
        }

        //launch server
        launch {
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
    }
}
