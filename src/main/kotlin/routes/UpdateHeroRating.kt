package com.example.routes

import com.example.models.ApiResponse
import com.example.models.HeroRatingRequest
import com.example.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.updateHeroRating(
    repository: HeroRepository
) {
    // маршрут позволяет дойти конкретного элемента базы данных и взять конкретное свойство
    put(
        "/heroes/{heroId}/rating"
    ) {

        val heroId = call.parameters["heroId"]?.toIntOrNull()


        if (heroId == null){
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Invalid hero id"
                ),
                status = HttpStatusCode.BadRequest
            )
            return@put
        }

        try {

            val request =  call.receive<HeroRatingRequest>()

            val rating = request.rating

            if (rating !in 1..5) {
                call.respond(
                    message = ApiResponse(
                        success = false,
                        message = "Invalid rating"
                    ),
                    status = HttpStatusCode.BadRequest
                )
                return@put
            }

            val response = repository.updateHeroRating(heroId = heroId, rating = rating.toDouble())


            call.respond(
                status = HttpStatusCode.OK,
                message = response
            )


        }catch (e: IllegalArgumentException) {
            call.respond(
                status = HttpStatusCode.BadRequest,
                message = ApiResponse(success = false, message = e.message)
            )
        } catch (e: Exception) {
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = ApiResponse(success = false, message = "Failed to update rating.")
            )

        }

    }

}