package com.example

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import com.example.repository.HeroRepositoryImpl
import com.example.repository.NEXT_PAGE_KEY
import com.example.repository.PREVIOUS_PAGE_KEY
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.*

class ServerTest {

    @Test
    fun `test root endpoint`() = testApplication {
        // loads default configuration
        application{module()}

        client.get ("/").apply {
            assertEquals(HttpStatusCode.OK, actual = status)
            assertEquals("Respond from server", actual = bodyAsText())

        }
        // verify server root returns 200
        assertEquals(HttpStatusCode.OK, client.get("/").status)


    }


    private val heroRepository = HeroRepositoryImpl()

    @Test
    fun `access all heroes endpoint, query all pages, assert correct information`() = testApplication {
        application {
            module()
        }




        val pages = 1..5
        val heroesByPage = listOf(
            heroRepository.page1,
            heroRepository.page2,
            heroRepository.page3,
            heroRepository.page4,
            heroRepository.page5
        )
        pages.forEach { page ->
            client.get("heroes?page=$page").apply {
                println("CURRENT PAGE: $page")
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = status
                )
                val pageInfo = calculatePage(page)
                val responseBody = bodyAsText()
                val actual = Json.decodeFromString<ApiResponse>(responseBody)
                val expected = ApiResponse(
                    success = true,
                    message = "ok",
                    prefPage = pageInfo[PREVIOUS_PAGE_KEY],
                    nextPage = pageInfo[NEXT_PAGE_KEY],
                    heroes = heroesByPage[page - 1],
                    lastUpdater = actual.lastUpdater // добавляю после обновления ApiResponse
                )

                println("PREV PAGE: ${pageInfo[PREVIOUS_PAGE_KEY]}")
                println("NEXT PAGE: ${pageInfo[NEXT_PAGE_KEY]}")
                println("HEROES: ${heroesByPage[page - 1]}")
                assertEquals(
                    expected = expected,
                    actual = actual,
                    message = "Page $page response should match"
                )
            }
        }
    }

    @Test
    fun `access search heroes endpoint, query hero name, assert multiple hero result`() = testApplication {
        application {
            module()
        }
        client.get("/heroes/search?name=фушигуро").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val responseBody = bodyAsText()
            val actual = Json.decodeFromString<ApiResponse>(responseBody)
                .heroes.size

            assertEquals(
                expected = 2,
                actual = actual
            )
        }
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

}


