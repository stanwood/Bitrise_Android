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

package io.stanwood.bitrise.util.databinding;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
