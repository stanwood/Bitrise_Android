/*
 * Copyright 2018 stanwood Gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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