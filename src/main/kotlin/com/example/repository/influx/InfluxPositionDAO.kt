package com.example.repository.influx

import com.example.domain.Position
import com.example.repository.PositionDAO
import com.influxdb.client.kotlin.InfluxDBClientKotlin

class InfluxPositionDAO(
    private val influxDBClientKotlin: InfluxDBClientKotlin,
) : PositionDAO {

    override fun getPositions(): List<Position> = listOf()

    override fun getPositionByUnitID(id: Int): List<Position>? = null
}