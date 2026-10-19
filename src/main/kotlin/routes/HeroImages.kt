package com.example.routes

import com.example.models.ApiResponse
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Route.heroImages(

) {

    get("/images/{filename}") {

        val filename = call.parameters["filename"]

        if (filename.isNullOrBlank()){
            call.respond(
                status = HttpStatusCode.BadRequest,
                message = ApiResponse(
                    success = false,
                    message = "Name is Empty"
                )
            )
            return@get
        }

        val uploadFile = File("uploads/images", filename)

        if (uploadFile.exists()) {
            val contentType = imageContentType(uploadFile.extension)

            call.respondBytes(
                bytes = uploadFile.readBytes(),
                contentType = contentType
            )
            return@get

        }



        val resourceStream = call.application.environment.classLoader
            .getResourceAsStream("images/$filename")
        if (resourceStream != null) {
            val bytes = resourceStream.use { it.readBytes() }

            val contentType = imageContentType(filename.substringAfterLast('.'))

            call.respondBytes(bytes, contentType)

            return@get
        }

        call.respond(
            HttpStatusCode.NotFound
        )



    }





}

private fun imageContentType(extension: String) : ContentType = when(extension.lowercase()){
    "png" -> ContentType.Image.PNG
    "webp" -> ContentType("image", "webp")
    else -> {
        ContentType.Image.JPEG
    }
}