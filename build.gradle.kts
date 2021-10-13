val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kgraphql_version: String by project
val influxdb_client_version: String by project
val main_class: String by project

plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
    kotlin("jvm") version "1.5.31"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("$main_class")
}

tasks {
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", "$main_class"))
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("com.apurebase:kgraphql:$kgraphql_version")
    implementation("com.apurebase:kgraphql-ktor:$kgraphql_version")
    implementation("com.influxdb:influxdb-client-kotlin:$influxdb_client_version")
    implementation("com.influxdb:flux-dsl:$influxdb_client_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}