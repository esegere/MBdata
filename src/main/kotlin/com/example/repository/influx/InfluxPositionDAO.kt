package com.example.repository.influx

import com.example.domain.Position
import com.example.repository.PositionDAO

class InfluxPositionDAO : PositionDAO {
    override fun getPositions(): List<Position> {
        TODO("Not yet implemented")
    }

    override fun getPositionByUnitID(id: Int): List<Position>? {
        TODO("Not yet implemented")
    }
}