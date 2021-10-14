package com.example


import com.example.ingest.retrieveAPIInfo
import com.example.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.*


fun main(): Unit = runBlocking {
    initDB()

    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080 // hardcoded value for default port

    async(Dispatchers.IO) { // in order to perform concurrent IO

        launch { //launch client
            while (true) {
                retrieveAPIInfo()
                delay(120000) //every two minutes
            }
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
