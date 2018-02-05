package io.stanwood.bitrise.util.databinding

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.stanwood.bitrise.BR

class ViewModelLiveDataAdapter(
        diffCallback: DiffCallback<Any>,
        @LayoutRes private val layoutResId: Int,
        internal val variableId: Int)
    : PagedListAdapter<Any, ViewModelLiveDataAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutResId, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Any) {
            binding.setVariable(variableId, item)
            binding.notifyPropertyChanged(BR._all)
            binding.executePendingBindings()
            binding.invalidateAll()
        }
    }
}