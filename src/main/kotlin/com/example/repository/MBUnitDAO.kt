package com.example.repository

import com.example.graphql.MBUnit

interface MBUnitDAO {
    fun getUnitByVehicleId(vehicleId: Int): MBUnit?
    fun getUnits(): List<MBUnit>
    fun addUnit(mbUnit: MBUnit)
}