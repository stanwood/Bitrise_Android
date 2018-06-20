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