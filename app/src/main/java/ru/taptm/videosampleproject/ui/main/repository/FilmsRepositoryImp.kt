package ru.taptm.videosampleproject.ui.main.repository

import ru.taptm.videosampleproject.ui.main.models.Film
import ru.taptm.videosampleproject.ui.main.models.RowCollection
import ru.taptm.videosampleproject.ui.main.repository.network.commons.Resource
import ru.taptm.videosampleproject.ui.main.repository.network.commons.ResponseHandler
import ru.taptm.videosampleproject.ui.main.repository.network.responces.FilmResponse
import ru.taptm.videosampleproject.ui.main.repository.network.services.FilmApi

interface FilmsRepository {
    suspend fun getMainScreenData(): Resource<List<RowCollection>>
}

class FilmsRepositoryImp(
    private val filmApi: FilmApi,
    private val responseHandler: ResponseHandler
) : FilmsRepository {

    override suspend fun getMainScreenData(): Resource<List<RowCollection>> {
        return try {
            val result = arrayListOf<RowCollection>()
            val resultPremier = filmApi.getFilmsPremier()
            val resultRecommendation = filmApi.getFilmsRecommendation()
            result.add(map(resultPremier.results))
            result.add(map(resultRecommendation.results))
            return responseHandler.handleSuccess(result)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    private fun map(data: List<FilmResponse.Result>): RowCollection {
        val filmsList = arrayListOf<Film>()
        var title = ""
        data.forEach { item ->
            title = item.name
            val filmName = item.objectX.name ?: ""
            val urlImage = item.objectX.picture ?: ""
            filmsList.add(Film(filmName, urlImage))
        }
        return RowCollection(title, filmsList)
    }
}