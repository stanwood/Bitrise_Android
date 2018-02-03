package io.stanwood.bitrise.util.databinding;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\"\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005H\u0007\u001a(\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0010"}, d2 = {"setDivider", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "orientation", "", "setEndOfListReachedLister", "listener", "Lio/stanwood/bitrise/util/databinding/EndOfListReachedListener;", "loadMoreThreshold", "setItems", "items", "", "", "layoutResId", "setOrientation", "app_debug"})
public final class RecyclerViewDataBindingsKt {
    
    @android.databinding.BindingAdapter(requireAll = true, value = {"items", "itemLayout"})
    public static final void setItems(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> items, @android.support.annotation.LayoutRes()
    int layoutResId) {
    }
    
    @android.databinding.BindingAdapter(value = {"orientation"})
    public static final void setOrientation(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView recyclerView, int orientation) {
    }
    
    @android.databinding.BindingAdapter(value = {"divider"})
    public static final void setDivider(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView recyclerView, int orientation) {
    }
    
    @android.databinding.BindingAdapter(requireAll = true, value = {"endOfListReached", "loadMoreThreshold"})
    public static final void setEndOfListReachedLister(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
    io.stanwood.bitrise.util.databinding.EndOfListReachedListener listener, int loadMoreThreshold) {
    }
}