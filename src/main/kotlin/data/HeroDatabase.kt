package com.example.data

import com.example.data.HeroTable.abilities
import com.example.data.HeroTable.about
import com.example.data.HeroTable.day
import com.example.data.HeroTable.family
import com.example.data.HeroTable.image
import com.example.data.HeroTable.month
import com.example.data.HeroTable.name
import com.example.data.HeroTable.natureTypes
import com.example.data.HeroTable.power
import com.example.data.HeroTable.rating
import com.example.models.Hero
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import kotlin.collections.map

object HeroDatabase {

    private val json = Json { ignoreUnknownKeys = true }

    fun init(seedHeroes: () -> List<Hero>) {
        File("data").mkdirs()

        Database.connect(
            url = "jdbc:sqlite:data/heroes.db",
            driver = "org.sqlite.JDBC"
        )

        transaction {
            SchemaUtils.create(HeroTable)

            if (HeroTable.selectAll().count() == 0L) {
                seedHeroes().forEach { hero ->
                    insertHero(hero)
                }
            }
        }
    }

    private fun insertHeroRow(hero: Hero) {
        HeroTable.insert {
            it[id] = hero.id
            it[name] = hero.name
            it[image] = hero.image
            it[about] = hero.about
            it[rating] = hero.rating
            it[power] = hero.power
            it[month] = hero.month
            it[day] = hero.day
            it[family] = json.encodeToString(hero.family)
            it[abilities] = json.encodeToString(hero.abilities)
            it[natureTypes] = json.encodeToString(hero.natureTypes)
        }
    }

    fun insertHero(hero: Hero) {
        transaction {
            insertHeroRow(hero)
        }
    }

    fun getAllHeroes(): List<Hero> = transaction {
        HeroTable.selectAll().map { row ->

            Hero(
                id = row[HeroTable.id],
                name = row[name],
                image = row[image],
                about = row[about],
                rating = row[rating],
                power = row[power],
                month = row[month],
                day = row[day],
                family = json.decodeFromString(row[family]),
                abilities = json.decodeFromString(row[abilities]),
                natureTypes = json.decodeFromString(row[natureTypes]),
            )

        }.sortedBy { hero -> hero.id }
    }

    fun nextHeroId(): Int = transaction {
        var maxId = HeroTable.selectAll().maxOfOrNull { row ->
            row[HeroTable.id]

        } ?: 0
        maxId + 1
    }


}





