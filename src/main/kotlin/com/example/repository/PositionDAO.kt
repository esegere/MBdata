package com.example.repository

import com.example.domain.Position
import com.example.domain.Town

interface PositionDAO {
    fun listTowns(): List<Town> = listOf(
        *Town.values()
    )

    fun getPositions(): List<Position>
    fun getPositionByUnitID(id: Int): List<Position>?
}