package com.example.plugins

import com.example.repository.database.Positions
import com.example.repository.database.Units
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun initDB() {
    val config = HikariConfig().apply {
        driverClassName = "org.sqlite.JDBC"
        jdbcUrl = "jdbc:sqlite:/app/data.sqlite"
        maximumPoolSize = 3
        isAutoCommit = true
        transactionIsolation = "TRANSACTION_SERIALIZABLE"
    }.also { config ->
        config.validate()
    }

    Database.connect(HikariDataSource(config)) // conects using pool, from here just use transaction{...}

    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Units, Positions)
    }
}