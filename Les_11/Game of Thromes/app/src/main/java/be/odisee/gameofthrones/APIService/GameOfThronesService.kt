package be.odisee.gameofthrones.APIService

import be.odisee.gameofthrones.Personage
import retrofit2.http.GET
import retrofit2.http.Path

interface GameOfThronesService {

    @GET("Characters")
    suspend fun getAllPersonages(): List<Personage>

    @GET("Characters/{id}")
    suspend fun getPersonage(@Path("id") id: Int): Personage
}