package com.jheank16oz.materialcolortool.theme

import android.view.View
import androidx.viewpager.widget.ViewPager


/**
 *
 *  <p>DepthPageTransformer</p>
 */
class DepthPageTransformer : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        val pageWidth = view.width

        when {
            position < -1 ->
                // This page is way off-screen to the left.
                view.alpha = 0F
            position <= 0 -> { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.alpha = 1F
                view.translationX = 0F
                view.scaleX = 1F
                view.scaleY = 1F

            }
            position <= 1 -> {
                // Fade the page out.
                view.alpha = 1 - position

                // Counteract the default slide transition
                view.translationX = pageWidth * -position

                // Scale the page down (between MIN_SCALE and 1)
                val scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position))
                view.scaleX = scaleFactor
                view.scaleY = scaleFactor

            }
            else -> // This page is way off-screen to the right.
                view.alpha = 0F
        }
    }

    companion object {
        private const val MIN_SCALE = 0.75f
    }
}