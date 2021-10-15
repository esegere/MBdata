package com.example.computations

import com.example.domain.Town
import kotlin.math.pow
import kotlin.math.sqrt

@JvmInline
value class Latitude(val latitude: Double)

@JvmInline
value class Longitude(val longitude: Double)

typealias Point = Pair<Latitude, Longitude>
typealias  Location = Pair<Point, Town>

private object staticData {
    val townLocations: List<Location> =
        listOf(
            (Latitude(19.4857819) to Longitude(-99.2171045)) to
                    Town.AZCAPOTZALCO,
            (Latitude(19.318163) to Longitude(-99.3180718)) to
                    Town.ALVARO_OBREGON,
            (Latitude(19.3804896) to Longitude(-99.1790512)) to
                    Town.BENITO_JUAREZ,
            (Latitude(19.3281992) to Longitude(-99.1874338)) to
                    Town.COYOACAN,
            (Latitude(19.3186934) to Longitude(-99.3758709)) to
                    Town.CUAJIMALPA_DE_MORELOS,
            (Latitude(19.4328036) to Longitude(-99.1882921)) to
                    Town.CUAUHTEMOC,
            (Latitude(19.5187603) to Longitude(-99.1839977)) to
                    Town.GUSTAVO_A_MADERO,
            (Latitude(19.3989636) to Longitude(-99.131504)) to
                    Town.IZTACALCO,
            (Latitude(19.3428324) to Longitude(-99.1202118)) to
                    Town.IZTAPALAPA,
            (Latitude(19.2754579) to Longitude(-99.3350273)) to
                    Town.MAGDALENA_CONTRERAS,
            (Latitude(19.4296549) to Longitude(-99.246706)) to
                    Town.MIGUEL_HIDALGO,
            (Latitude(19.1938657) to Longitude(-99.0333644)) to
                    Town.MILPA_ALTA,
            (Latitude(19.2007677) to Longitude(-99.3486766)) to
                    Town.TLALPAN,
            (Latitude(19.268839) to Longitude(-99.0746754)) to
                    Town.TLAHUAC,
            (Latitude(19.432053) to Longitude(-99.1223488)) to
                    Town.VENUSTIANO_CARRANZA,
            (Latitude(19.2364834) to Longitude(-99.1507604)) to
                    Town.XOCHIMILCO,
        )
}

private fun distance(a: Point, b: Point): Double =
    sqrt(
        (a.first.latitude - b.first.latitude).pow(2) +
                (a.second.longitude - b.second.longitude).pow(2)
    )

fun nearestTown(latitude: Latitude, longitude: Longitude): Town =
    staticData.townLocations.sortedBy {
        distance(it.first, latitude to longitude)
    }.last().second