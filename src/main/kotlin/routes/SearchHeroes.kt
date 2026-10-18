package com.example.routes

import com.example.repository.HeroRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.util.StringValues

fun Route.searchHeroes (
    repository: HeroRepository
) {
    get("/heroes/search") {
        val name  = call.request.queryParameters["name"]

        val apiResponse = repository.searchHeroes(name)

        call.respond(message = apiResponse, status = HttpStatusCode.OK)
    }
}