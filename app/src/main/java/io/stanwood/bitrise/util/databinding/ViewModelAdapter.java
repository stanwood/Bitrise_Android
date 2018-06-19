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

package io.stanwood.bitrise.util.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;

import io.stanwood.bitrise.BR;


public class ViewModelAdapter
        extends RecyclerView.Adapter<ViewModelAdapter.ViewHolder> {

    private class ListChangedCallback extends ObservableList.OnListChangedCallback<ObservableList<Object>> {
        @Override
        public void onChanged(ObservableList<Object> objects) {
            notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(ObservableList<Object> objects, int positionStart, int itemCount) {
            notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeInserted(ObservableList<Object> objects, int positionStart, int itemCount) {
            notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeMoved(ObservableList<Object> objects, int fromPosition, int toPosition, int itemCount) {
            notifyDataSetChanged();
        }

        @Override
        public void onItemRangeRemoved(ObservableList<Object> objects, int positionStart, int itemCount) {
            notifyItemRangeRemoved(positionStart, itemCount);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object item) {
            binding.setVariable(variableId, item);
            binding.notifyPropertyChanged(BR._all);
            binding.executePendingBindings();
            binding.invalidateAll();
        }
    }

    @NonNull
    private List<Object> items;

    @LayoutRes
    private int layoutResId;
    private int variableId;

    public ViewModelAdapter(@NonNull List<Object> items, @LayoutRes int layoutResId, int variableId) {
        this.items = items;
        this.layoutResId = layoutResId;
        this.variableId = variableId;

        if (items instanceof ObservableList) {
            ObservableList observableList = (ObservableList) items;
            observableList.addOnListChangedCallback(new ListChangedCallback());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        ViewDataBinding binding =
                DataBindingUtil.inflate(inflater, layoutResId, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewModelAdapter.ViewHolder holder, int position) {
        Object item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
