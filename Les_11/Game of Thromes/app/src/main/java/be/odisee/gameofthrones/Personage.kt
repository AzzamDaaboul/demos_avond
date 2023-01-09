package be.odisee.gameofthrones

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Personage(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val title: String,
    val family: String,
    val imageUrl: String
)
