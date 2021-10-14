package com.example.ingest


import com.example.repository.webService.RetrofitClient

suspend fun retrieveAPIInfo() {
    val call = RetrofitClient.webService.getUnits(2)
    if (call.isSuccessful) {
        call.body()?.result?.total.let(::println)
    }
}