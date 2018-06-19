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
import android.support.annotation.LayoutRes
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.stanwood.bitrise.BR

interface EndOfListReachedListener {
    fun invoke(itemCount: Int)
}

@BindingAdapter(value = ["items", "itemLayout"], requireAll = true)
fun setItems(
        recyclerView: RecyclerView,
        items: List<Any>,
        @LayoutRes layoutResId: Int) {
    val adapter = recyclerView.adapter
    if(adapter == null) {
        recyclerView.adapter = ViewModelAdapter(items, layoutResId, BR.vm)
    }
}

@BindingAdapter(value = ["orientation"])
fun setOrientation(
        recyclerView: RecyclerView,
        orientation: Int) {
    recyclerView.apply {
        layoutManager = LinearLayoutManager(context, orientation, false)
    }
}

@BindingAdapter(value = ["divider"])
fun setDivider(
        recyclerView: RecyclerView,
        orientation: Int) {
    recyclerView.apply {
        addItemDecoration(DividerItemDecoration(context, orientation))
    }
}

@BindingAdapter(value = ["endOfListReached", "loadMoreThreshold"], requireAll = true)
fun setEndOfListReachedLister(
        recyclerView: RecyclerView,
        listener: EndOfListReachedListener,
        loadMoreThreshold: Int = 2) {
    recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView?.layoutManager

            if (layoutManager is LinearLayoutManager) {
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val itemCount = layoutManager.itemCount

                if (lastVisibleItemPosition + loadMoreThreshold > itemCount) {
                    listener.invoke(itemCount)
                }
            }
        }
    })
}