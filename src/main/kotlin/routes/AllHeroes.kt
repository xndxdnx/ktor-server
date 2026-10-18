package com.example.routes

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllHeroes(
    repository: HeroRepository
) {
    get("/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page >= 1)

            val apiResponse = repository.getAllHeroes(page = page)

            call.respond(message = apiResponse, status = HttpStatusCode.OK)

        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only numbers"),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Heroes not found"),
                status = HttpStatusCode.NotFound
            )
        }
    }
}