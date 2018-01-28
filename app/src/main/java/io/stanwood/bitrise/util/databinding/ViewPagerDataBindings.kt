package io.stanwood.bitrise.util.databinding

import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.databinding.BindingAdapter
import android.support.design.widget.TabLayout


@BindingAdapter(value = ["adapter"], requireAll = false)
fun setAdapter(viewPager: ViewPager, adapter: PagerAdapter) {
    viewPager.adapter = adapter
}

@BindingAdapter("tabs")
fun setViewPager(viewPager: ViewPager, tabLayout: TabLayout) {
    tabLayout.setupWithViewPager(viewPager)
}