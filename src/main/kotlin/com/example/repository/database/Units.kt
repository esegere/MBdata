package com.example.repository.database

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Units : Table("units") {
    val id: Column<Int> = integer("id").autoIncrement()
    val vehicleId: Column<Int> = integer("vehicle_id").uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}
