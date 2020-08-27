package com.pocraft.gassai.utility

import android.view.View
import android.view.WindowInsets

inline fun View.doOnApplyWindowInsets(crossinline f: (View, WindowInsets) -> Unit) {
    setOnApplyWindowInsetsListener { v, insets ->
        f(v, insets)
        insets
    }
    requestApplyInsetsWhenAttached()
}

fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        requestApplyInsets()
    } else {
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewDetachedFromWindow(v: View?) = Unit

            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }
        })
    }
}