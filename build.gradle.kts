val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kgraphql_version: String by project
val influxdb_client_version: String by project
val main_class: String by project
val retrofit_version: String by project
val gson_version: String by project
val exposed_version: String by project
val postgresql_version: String by project
val hikari_version: String by project

plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
    kotlin("jvm") version "1.5.31"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set(main_class)
}

tasks {
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", main_class))
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    //Gson
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("com.google.code.gson:gson:$gson_version")
    //server
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    implementation("io.ktor:ktor-html-builder:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    //graphql
    implementation("com.apurebase:kgraphql:$kgraphql_version")
    implementation("com.apurebase:kgraphql-ktor:$kgraphql_version")
    //exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    // postgres
    implementation("org.postgresql:postgresql:$postgresql_version")
    //hikari
    implementation("com.zaxxer:HikariCP:$hikari_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}