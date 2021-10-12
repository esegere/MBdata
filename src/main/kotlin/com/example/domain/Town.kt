package com.example.domain

@JvmInline
value class Latitude(val value: Double)

@JvmInline
value class Longitude(val value: Double)

enum class Town() {
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
    XOCHIMILCO;

    constructor(latitude: Latitude, longitude: Longitude) : this() {
        TLAHUAC
    }
}