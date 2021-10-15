package com.example.repository.database

import com.example.domain.Town
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object Positions : Table("positions") {
    val id: Column<Int> = integer("id").autoIncrement()
    val unitId: Column<Int> = integer("unit_id") references Units.id
    val date: Column<LocalDateTime> = datetime("date")
    val town: Column<Town> = enumerationByName("town", 30, Town::class)

    override val primaryKey = PrimaryKey(id)

    init {
        uniqueIndex("location", unitId, date)
    }
}
