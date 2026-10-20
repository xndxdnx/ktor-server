package com.example.plugins

import io.ktor.http.HttpHeaders
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*
import kotlin.time.Duration.Companion.days

fun Application.configureDefaultHeaders() {

    val safeTime = 365.days.inWholeSeconds

    install(DefaultHeaders) {

        header(HttpHeaders.CacheControl, "public, maxAge = $safeTime immutable")

//        header("X-Engine", "Ktor") // will send this header with each response
    }
}