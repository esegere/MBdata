package com.example.repository.webService

import com.example.domain.RemoteMBUnitResponse
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

@JvmInline
value class Latitude(val value: Double)

@JvmInline
value class Longitude(val value: Double)

interface LocationService {

    @GET("datastore_search?resource_id=ad360a0e-b42f-482c-af12-1fd72140032e")
    suspend fun getUnits(@Query("limit") limit: Int, @Query("offset") offset: Int = 0): Response<RemoteMBUnitResponse>

}

object RetrofitLocationClient {
    private val urlString =
        "https://datos.cdmx.gob.mx/api/3/action/"


    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(urlString)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().create()
                )
            )
            .build()
            .create(WebService::class.java)
    }
}