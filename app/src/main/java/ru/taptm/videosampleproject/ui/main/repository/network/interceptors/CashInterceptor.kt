package ru.taptm.videosampleproject.ui.main.repository.network.interceptors

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import ru.taptm.videosampleproject.ui.main.common.extensions.isHasNetwork

class CashInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = if (context.isHasNetwork())
            request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
        else
            request.newBuilder().header(
                "Cache-Control",
                "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
            ).build()
        return chain.proceed(request)
    }

}