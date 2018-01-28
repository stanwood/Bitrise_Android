package io.stanwood.bitrise.util.databinding

import android.databinding.BindingAdapter
import android.view.inputmethod.EditorInfo
import android.widget.EditText


interface TextSubmissionListener {
    fun invoke(a: String)
}

@BindingAdapter(value = ["onTextSubmitted"])
fun test(editText: EditText, listener: TextSubmissionListener) {
    editText.setOnEditorActionListener { _, actionId, _ ->
        if(actionId == EditorInfo.IME_ACTION_DONE) {
            listener.invoke(editText.text.toString())
            true
        }
        false
    }
}

@BindingAdapter(value = ["error"])
fun test(editText: EditText, error: String?) {
    editText.error = error
}