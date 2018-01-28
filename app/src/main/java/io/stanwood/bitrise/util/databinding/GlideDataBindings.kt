package io.stanwood.bitrise.util.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide


@BindingAdapter(value = ["url"])
fun setImage(
        imageView: ImageView,
        url: String) {
    Glide
            .with(imageView)
            .load(url)
            .into(imageView)
}