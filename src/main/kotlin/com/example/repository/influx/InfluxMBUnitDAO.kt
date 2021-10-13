package com.example.repository.influx

import com.example.graphql.MBUnit
import com.example.repository.MBUnitDAO
import com.example.repository.PositionDAO
import com.influxdb.client.InfluxDBClient

class InfluxMBUnitDAO(
    private val influxDBClientKotlin: InfluxDBClient,
    private val positionDAO: PositionDAO
) : MBUnitDAO {

    override fun getUnitById(id: Int): MBUnit? = null

    override fun getUnits(): List<MBUnit> = listOf()

}