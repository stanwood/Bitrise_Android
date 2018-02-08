package io.stanwood.bitrise.util.databinding

import android.databinding.BindingAdapter
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation


@BindingAdapter("android:visibility")
fun setVisibility(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("rotate")
fun rotate(view: View, rotate: Boolean) {
    if (rotate) {
        if (view.animation == null) {
            view.animation = RotateAnimation(0f, 360f, view.pivotX, view.pivotY)
                    .apply { repeatMode = Animation.INFINITE }
            view.animate()
        }
    } else {
        view.clearAnimation()
    }
}