package com.example.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.calllogging.CallLogging


// плагин для логирования запросов на сервер и явного отслеживания состояний
fun Application.configureMonitoring() {
    install(CallLogging)
}