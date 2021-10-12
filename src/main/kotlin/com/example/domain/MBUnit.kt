package com.example.graphql

import com.example.domain.Position

data class MBUnit(
    val id: Int,
    val positions: List<Position> = listOf()
)
