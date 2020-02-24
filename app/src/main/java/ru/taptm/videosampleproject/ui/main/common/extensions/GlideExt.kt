package ru.taptm.videosampleproject.ui.main.common.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadWithCash(url: String, roundedCorners: Int = 1) {
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transform(CenterCrop(), RoundedCorners(roundedCorners))
        .into(this)
}