package com.example.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

fun initDB() {
    val DATABASE: String = "mbdata"
    val PORT: Int = 54321
    val HOST: String = "database"

    val config = HikariConfig().apply {
        driverClassName = "org.postgresql.Driver"
        jdbcUrl = "jdbc:postgresql://$HOST:$PORT/$DATABASE"
        username = "ktor"
        password = "secret"
        maximumPoolSize = 3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    }.also { config ->
        config.validate()
    }
    print("connected")
//    config.schema = <dbSchema>
    val ds = HikariDataSource(config)
    Database.connect(ds)
}