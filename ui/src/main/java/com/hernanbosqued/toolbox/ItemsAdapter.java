package com.hernanbosqued.toolbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hernanbosqued.toolbox.domain.Item;


class ItemsAdapter extends BaseAdapter<Item, ItemViewHolder> {

    private ITEM_TYPES type;
    private ItemViewHolder.OnItemClickListener listener;

    public ItemsAdapter(ITEM_TYPES type, ItemViewHolder.OnItemClickListener listener) {
        this.type = type;
        this.listener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        switch (type) {
            case POSTER:
                layout = R.layout.layout_poster;
                break;
            case THUMB:
                layout = R.layout.layout_thumb;
                break;
            default:
                //error layout here
                layout = 0;
                break;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ItemViewHolder(view, listener);
    }
}
