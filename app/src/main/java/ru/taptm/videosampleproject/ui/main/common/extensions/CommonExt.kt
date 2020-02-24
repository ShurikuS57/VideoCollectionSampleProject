package ru.taptm.videosampleproject.ui.main.common.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View

fun View.dp2px(dp: Int): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}

fun Context.dp2px(dp: Int): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}


fun Context.isHasNetwork(): Boolean {
    var isConnected: Boolean = false
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}