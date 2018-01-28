package io.stanwood.bitrise.util.databinding

import android.databinding.BindingAdapter
import android.view.View


@BindingAdapter("android:visibility")
fun setVisibility(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}