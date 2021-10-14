package com.example.ingest


import com.example.repository.webService.RetrofitClient

suspend fun retrieveAPIInfo() {
        val pagingAmount = 10
        val call = RetrofitClient.webService.getUnits(0)
        call.body()?.result?.total?.let { totalPages: Int ->
                for (i in 0..totalPages step pagingAmount) {
                        //TODO: retrieve avery unit
                }
        }
}