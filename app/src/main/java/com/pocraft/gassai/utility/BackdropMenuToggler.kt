package com.pocraft.gassai.utility

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.Interpolator
import com.pocraft.gassai.R

class BackdropMenuToggler @JvmOverloads internal constructor(
    private val context: Context, private val sheet: View,
    private val interpolator: Interpolator? = null,
    private val openIcon: Drawable? = null,
    private val closeIcon: Drawable? = null
) : View.OnClickListener {
    private val animatorSet = AnimatorSet()
    private val height: Int
    private var backdropShown = false

    init {
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
    }

    override fun onClick(v: View) {
        backdropShown = !backdropShown

        animatorSet.removeAllListeners()
        animatorSet.end()
        animatorSet.cancel()

        val translateY = height - context.resources.getDimensionPixelSize(R.dimen.bottom_sheet_reveal_height)
        val animator = ObjectAnimator.ofFloat(sheet, "translationY" , (if (backdropShown) translateY else 0).toFloat())
        animator.duration = 300
        if (interpolator != null) {
            animator.interpolator = interpolator
        }
        animatorSet.play(animator)
        animator.start()
    }
}