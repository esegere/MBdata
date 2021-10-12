package com.example.repository.influx

import com.influxdb.client.kotlin.InfluxDBClientKotlin
import com.influxdb.client.kotlin.InfluxDBClientKotlinFactory

object InfluxDB {
    private val influxDBClient: InfluxDBClientKotlin = InfluxDBClientKotlinFactory.create("http://localhost:8086")
    val positions = InfluxPositionDAO(influxDBClient)
    val units = InfluxMBUnitDAO(influxDBClient, positions)
}