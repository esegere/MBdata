package com.example.graphql

import java.util.*

enum class Town {
    AZCAPOTZALCO,
    ALVARO_OBREGON,
    BENITO_JUAREZ,
    COYOACAN,
    CUAJIMALPA_DE_MORELOS,
    CUAUHTEMOC,
    GUSTAVO_A_MADERO,
    IZTACALCO,
    IZTAPALAPA,
    MAGDALENA_CONTRERAS,
    MIGUEL_HIDALGO,
    MILPA_ALTA,
    TLALPAN,
    TLAHUAC,
    VENUSTIANO_CARRANZA,
    XOCHIMILCO,
}

data class Position(
    val date: String,
    val town: Town,
)

data class MBUnit(
    val id: Int,
)