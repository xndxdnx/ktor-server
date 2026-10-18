package com.example

import com.example.repository.HeroRepository
import com.example.routes.getAllHeroes
import com.example.routes.root
import com.example.routes.searchHeroes
import io.ktor.server.application.*
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val heroRepository: HeroRepository by inject()

    routing {
        root()
        searchHeroes(heroRepository)
        getAllHeroes(heroRepository)

        // статические пути для отладки
        static("/images") {
            resources("images")
        }
    }
}