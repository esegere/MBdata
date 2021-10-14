package com.example.repository.influx

import com.example.domain.Position
import com.example.domain.Town
import com.example.graphql.MBUnit
import com.example.repository.MBUnitDAO
import com.example.repository.PositionDAO
import com.influxdb.client.kotlin.InfluxDBClientKotlin

class InfluxMBUnitDAO(
    private val influxDBClientKotlin: InfluxDBClientKotlin,
    private val positionDAO: PositionDAO
) : MBUnitDAO {

    override fun getUnitById(id: Int): MBUnit? = null

    override fun getUnits(): List<MBUnit> = listOf(
        MBUnit(
            5, listOf(
                Position(Town.TLAHUAC, ""),
                Position(Town.TLALPAN, ""),
                Position(Town.XOCHIMILCO, ""),
            )
        )
    )

}