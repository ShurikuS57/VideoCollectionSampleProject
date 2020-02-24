package ru.taptm.videosampleproject.ui.main.di

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.taptm.videosampleproject.BuildConfig
import ru.taptm.videosampleproject.ui.main.repository.network.interceptors.CashInterceptor
import ru.taptm.videosampleproject.ui.main.repository.network.services.FilmApi

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(cash: Cache, cashInterceptor: CashInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder()
        .cache(cash)
        .addInterceptor(cashInterceptor)
        .build()
}

fun provideCashInterceptor(context: Context): CashInterceptor {
    return CashInterceptor(context)
}

fun provideForecastApi(retrofit: Retrofit): FilmApi = retrofit.create(FilmApi::class.java)

fun provideNetworkCash(context: Context): Cache {
    val cacheSize = (5 * 1024 * 1024).toLong()
    return Cache(context.cacheDir, cacheSize)
}