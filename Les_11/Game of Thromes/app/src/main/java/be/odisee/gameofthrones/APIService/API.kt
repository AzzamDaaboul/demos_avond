package be.odisee.gameofthrones.APIService

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .baseUrl("https://thronesapi.com/api/v2/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

object API {
    val service: GameOfThronesService by lazy {
        retrofit.create(GameOfThronesService::class.java)
    }
}
