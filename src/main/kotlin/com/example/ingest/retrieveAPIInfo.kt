package com.example.ingest


import com.example.computations.Latitude
import com.example.computations.Longitude
import com.example.computations.nearestTown
import com.example.domain.Position
import com.example.domain.RemoteMBUnit
import com.example.repository.database.SQLiteMBUnitDAO
import com.example.repository.database.SQLitePositionDAO
import com.example.repository.webService.RetrofitMBClient


private object persistence {
    val positionDAO = SQLitePositionDAO()
    val unitsDAO = SQLiteMBUnitDAO(positionDAO)
}

fun addRegister(remoteUnit: RemoteMBUnit) {
    persistence.unitsDAO.addUnit(remoteUnit.vehicleId)
    persistence.positionDAO.addPositionForUnitID(
        remoteUnit.vehicleId,
        Position(
            nearestTown(
                Latitude(remoteUnit.positionLatitude),
                Longitude(remoteUnit.positionLongitude)
            ),
            remoteUnit.dateUpdated
        )
    )
}


suspend fun retrieveElements(from: Int, amount: Int) {
    val call = RetrofitMBClient.webService.getUnits(amount, from)
    call.body()?.result?.records?.forEach {
        try {
            addRegister(it)
        } catch (e: Exception) {
            return
        }
    }
}

suspend fun retrieveAPIInfo() {
    val pagingAmount = 10
    val call = RetrofitMBClient.webService.getUnits(0)
    call.body()?.result?.total?.let { totalPages: Int -> // retrieve content pages by pagingAmount
        for (i in 0..totalPages step pagingAmount) {
            retrieveElements(i, pagingAmount)
        }
    }
}