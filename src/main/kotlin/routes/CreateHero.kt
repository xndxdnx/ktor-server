package com.example.routes

import com.example.models.ApiResponse
import com.example.models.HeroCreateRequest
import com.example.repository.HeroRepository
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.http.content.streamProvider
import io.ktor.server.request.receiveMultipart
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.path
import io.ktor.server.routing.post
import kotlinx.serialization.json.Json

private val json = Json { ignoreUnknownKeys = true }

fun Route.createHero(
    repository: HeroRepository
) {

    post(
        "/post/heroes"
    ) {
        var heroJson: String? = null
        var imageBytes: ByteArray? = null

        var fileExtension: String = "jpg"

        val multipart = call.receiveMultipart()

        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    if (part.name == "data") {
                        heroJson = part.value
                    }
                }
                is PartData.FileItem -> {
                    if (part.name == "image") {
                        imageBytes = part.streamProvider().readBytes()
                        fileExtension = part.originalFileName?.substringAfterLast('.', "jpg")?.lowercase() ?: "jpg"
                    }
                }
                else -> {

                }
            }

            part.dispose()
        }

        if (heroJson.isNullOrBlank() || imageBytes == null) {
            call.respond(
                status = HttpStatusCode.BadRequest,
                message = ApiResponse(
                    success = false,
                    message = "Не хватает данных"
                )

            )
            return@post


        }

        try {
            val request = json.decodeFromString<HeroCreateRequest>(heroJson)

            val response = repository.createHero(request, imageBytes, fileExtension)

            call.respond(
                status = HttpStatusCode.Created,
                message = response
            )

        }catch (e: IllegalArgumentException) {
            call.respond(
                status = HttpStatusCode.BadRequest,
                message = ApiResponse(
                    success = false,
                    message = e.message
                )

            )
        }catch (e: Exception) {
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = ApiResponse(
                    success = false,
                    message = e.message
                )

            )
        }

    }


}