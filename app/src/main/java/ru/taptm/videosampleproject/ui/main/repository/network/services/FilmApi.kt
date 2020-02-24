package ru.taptm.videosampleproject.ui.main.repository.network.services

import retrofit2.http.GET
import ru.taptm.videosampleproject.ui.main.repository.network.responces.FilmResponse

interface FilmApi {

    @GET("v2/5e4e4ec92f00006c0016a5b4")
    suspend fun getFilmsRecommendation(): FilmResponse

    @GET("v2/5e4e4f182f0000640016a5b8")
    suspend fun getFilmsPremier(): FilmResponse
}