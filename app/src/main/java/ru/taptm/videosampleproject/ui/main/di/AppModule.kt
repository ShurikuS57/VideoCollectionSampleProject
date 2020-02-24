package ru.taptm.videosampleproject.ui.main.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.taptm.videosampleproject.ui.main.repository.FilmsRepository
import ru.taptm.videosampleproject.ui.main.repository.FilmsRepositoryImp
import ru.taptm.videosampleproject.ui.main.repository.network.commons.ResponseHandler
import ru.taptm.videosampleproject.ui.main.screens.collections.CollectionsViewModel

val networkModule = module {
    factory { provideOkHttpClient(get(), get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
    single { provideNetworkCash(androidContext()) }
    single { provideCashInterceptor(androidContext()) }
    factory { ResponseHandler() }
}

val repositoryModule = module {
    single<FilmsRepository> { FilmsRepositoryImp(get(), get()) }
}

val viewModelModule = module {
    viewModel {
        CollectionsViewModel(
            get()
        )
    }
}

