package com.example.graphql


class MBUnit(val id: Int, ){
    public val positions: List<Position> by lazy { listOf(Position()) }
}
