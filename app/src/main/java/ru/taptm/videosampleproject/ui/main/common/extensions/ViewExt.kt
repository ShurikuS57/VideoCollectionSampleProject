package ru.taptm.videosampleproject.ui.main.common.extensions

import android.view.View
import android.view.ViewGroup

fun View.visible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

fun ViewGroup.visible() {
    this.visibility = View.VISIBLE
}

fun ViewGroup.gone() {
    this.visibility = View.GONE
}

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

inline fun View.visibleIf(condition: (() -> Boolean)) {
    visibility = if (condition.invoke()) View.VISIBLE else View.GONE
}

inline fun View.invisibleIf(condition: (() -> Boolean)) {
    visibility = if (condition.invoke()) View.INVISIBLE else View.VISIBLE
}

inline fun View.notVisibleIf(condition: (() -> Boolean)) {
    visibility = if (condition.invoke()) View.GONE else View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.setMargins(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
    val params = layoutParams as? ViewGroup.MarginLayoutParams ?: return
    params.setMargins(
        left ?: params.leftMargin, top ?: params.topMargin,
        right ?: params.rightMargin, bottom ?: params.rightMargin
    )
    params.marginEnd = right ?: params.marginEnd
    params.marginStart = left ?: params.marginStart
    layoutParams = params
}

fun View.setViewPadding(
    left: Int? = null,
    top: Int? = null,
    right: Int? = null,
    bottom: Int? = null
) {
    this.setPadding(
        left ?: this.paddingLeft, top ?: this.paddingTop,
        right ?: this.paddingRight, bottom ?: this.paddingBottom
    )
}

fun View.setHeight(value: Int) {
    val lp = layoutParams
    lp?.let {
        lp.height = value
        layoutParams = lp
    }
}

fun View.setWidth(value: Int) {
    val lp = layoutParams
    lp?.let {
        lp.width = value
        layoutParams = lp
    }
}

fun View.resize(width: Int, height: Int) {
    val lp = layoutParams
    lp?.let {
        lp.width = width
        lp.height = height
        layoutParams = lp
    }
}