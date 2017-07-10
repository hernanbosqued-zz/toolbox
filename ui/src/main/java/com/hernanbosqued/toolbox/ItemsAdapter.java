package com.hernanbosqued.toolbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hernanbosqued.toolbox.domain.Item;


class ItemsAdapter extends BaseAdapter<Item, ItemViewHolder> {

    private ItemViewHolder.OnItemClickListener listener;

    public ItemsAdapter( ItemViewHolder.OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ItemViewHolder(view,listener);
    }
}
