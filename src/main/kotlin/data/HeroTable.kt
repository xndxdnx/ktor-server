package com.example.data

import org.jetbrains.exposed.sql.Table


object HeroTable : Table("heroes") {


    val id = integer("id")
    val name = varchar("name", 255)
    val image = varchar("image", 512)
    val about = text("about")
    val rating = double("rating")
    val power = integer("power")
    val month = varchar("month", 255)
    val day = varchar("day", 255)
    val family = text("family")
    val natureTypes = text("natureTypes")
    val abilities = text("abilities")

    override val primaryKey = PrimaryKey(id)

}