package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class HeroRatingRequest(
    val rating: Int,
)
