package com.example.repository.database

import com.example.graphql.MBUnit
import com.example.repository.MBUnitDAO
import com.example.repository.PositionDAO
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


class SQLiteMBUnitDAO(
    private val positionDAO: PositionDAO
) : MBUnitDAO {

    override fun getUnitByVehicleId(vehicleId: Int): MBUnit? = transaction {
        Units.select { // get row for id
            Units.vehicleId eq vehicleId
        }.single()
            .let {
                MBUnit(
                    it[Units.vehicleId],
                    positionDAO.getPositionByUnitID(it[Units.id]) // positions for unit
                )
            }
    }

    override fun getUnits(): List<MBUnit> = transaction {
        Units.selectAll().map {
            MBUnit(
                it[Units.vehicleId],
                positionDAO.getPositionByUnitID(it[Units.id])
            )
        }
    }

    override fun addUnit(newVehicleId: Int): Unit = transaction {
        val found = Units.selectAll().any {  //first check does not already exist
            it[Units.vehicleId] == newVehicleId
        }
        if (found) return@transaction
        Units.insert {
            it[Units.vehicleId] = newVehicleId
        }
    }

}