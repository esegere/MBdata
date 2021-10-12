package com.example.repository

import com.example.domain.Position

interface PositionDAO {
    fun getPositions(): List<Position>
    fun getPositionByUnitID(id: Int): List<Position>?
}