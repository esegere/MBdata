package com.example.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

fun initDB() {
    val DATABASE: String = "mbdata"
    val PORT: Int = 5432
    val HOST: String = "localhost"

    val config = HikariConfig().apply {
        driverClassName = "org.postgresql.Driver"
        jdbcUrl = "jdbc:postgresql://$HOST:$PORT/$DATABASE"
        username = "esege"
        password = "hirake"
        maximumPoolSize = 3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    }.also { config ->
        config.validate()
    }
//    config.schema = <dbSchema>
    val ds = HikariDataSource(config)
    Database.connect(ds)
}