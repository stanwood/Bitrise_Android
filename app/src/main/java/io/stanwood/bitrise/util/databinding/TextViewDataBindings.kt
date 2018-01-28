package io.stanwood.bitrise.util.databinding

import android.databinding.BindingAdapter
import android.text.method.LinkMovementMethod
import android.widget.TextView


@BindingAdapter("enableLinks")
fun setHtml(textView: TextView, enable: Boolean) {
    if(enable) {
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}