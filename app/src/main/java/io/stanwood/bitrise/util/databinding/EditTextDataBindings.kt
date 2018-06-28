/*
 * Copyright (c) 2018 stanwood Gmbh
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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