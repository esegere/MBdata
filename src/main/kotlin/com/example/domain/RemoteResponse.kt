package com.example.domain

import com.google.gson.annotations.SerializedName

data class RemoteMBUnit(
    @SerializedName("date_updated") val dateUpdated: String,
    @SerializedName("vehicle_id") val vehicleId: Int,
    @SerializedName("position_latitude") val positionLatitude: Double,
    @SerializedName("position_longitude") val positionLongitude: Double,
)

data class RemoteMBUnitLinks(
    @SerializedName("start") val start: String,
    @SerializedName("next") val next: String,
)

data class RemoteMBUnitResult(
    @SerializedName("records") val records: List<RemoteMBUnit>,
    @SerializedName("_links") val links: RemoteMBUnitLinks,
    @SerializedName("total") val total: Int,
)

data class RemoteMBUnitResponse(
    @SerializedName("result") val result: RemoteMBUnitResult,
)
