package com.example.plugins

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*


// устанавливаем механизм для предооставления ресурсов и настраиваем формат
fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}