package ru.taptm.videosampleproject.ui.main.screens.collections

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import kotlinx.coroutines.Dispatchers
import ru.taptm.videosampleproject.ui.main.models.RowCollection
import ru.taptm.videosampleproject.ui.main.repository.FilmsRepository
import ru.taptm.videosampleproject.ui.main.repository.network.commons.Resource

class CollectionsViewModel(private val repo: FilmsRepository) : ViewModel() {

    private val collectionsData = MutableLiveData<Resource<List<RowCollection>>>()

    fun getFilms() {
        collectionsData.value = null
    }

    var collections = collectionsData.switchMap {
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            emit(repo.getMainScreenData())
        }
    }

}