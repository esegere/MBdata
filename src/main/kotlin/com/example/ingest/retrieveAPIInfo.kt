package com.example.ingest


import com.example.domain.Position
import com.example.domain.RemoteMBUnit
import com.example.domain.Town
import com.example.repository.database.SQLiteMBUnitDAO
import com.example.repository.database.SQLitePositionDAO
import com.example.repository.webService.RetrofitClient


private object persistence {
    val positionDAO = SQLitePositionDAO()
    val unitsDAO = SQLiteMBUnitDAO(positionDAO)
}

fun addRegister(remoteUnit: RemoteMBUnit) {
    persistence.unitsDAO.addUnit(remoteUnit.vehicleId)
    persistence.positionDAO.addPositionForUnitID(
        remoteUnit.vehicleId,
        Position(
            Town.TLAHUAC,
            remoteUnit.dateUpdated
        )
    )
}


suspend fun retrieveElements(from: Int, amount: Int) {
    val call = RetrofitClient.webService.getUnits(amount, from)
    call.body()?.result?.records?.forEach {
        addRegister(it)
    }
}

suspend fun retrieveAPIInfo() {
    val pagingAmount = 10
    val call = RetrofitClient.webService.getUnits(0)
    call.body()?.result?.total?.let { totalPages: Int -> // retrieve content pages by pagingAmount
        for (i in 0..totalPages step pagingAmount) {
            retrieveElements(i, pagingAmount)
        }
    }
}