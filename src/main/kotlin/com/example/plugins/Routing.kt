package com.example.plugins

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondHtml {
                head {
                    title("MB data")
                    meta {
                        httpEquiv = "refresh"
                        content = "1; url = https://esegere.github.io/MBdata/"
                    }
                }
                body {
                    h1 {
                        style = "text-align: center;"
                        +"MB data"
                    }
                    p {
                        style = "text-align: center;If your browser does not redirect you automatically in 5 seconds, "
                        a {
                            href = "https://esegere.github.io/MBdata/"
                            +"click here"
                        }
                    }
                }
            }
        }
    }

}