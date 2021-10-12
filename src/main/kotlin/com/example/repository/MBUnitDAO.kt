package com.example.repository

import com.example.graphql.MBUnit

interface MBUnitDAO {
    fun getUnitById(id: Int): MBUnit?
    fun getUnits(): List<MBUnit>
}