package com.hernanbosqued.toolbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hernanbosqued.toolbox.domain.ItemEntity;
import com.hernanbosqued.toolbox.domain.SectionEntity;

import java.util.List;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private List<ItemEntity> entities;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    public ItemsAdapter(List<ItemEntity> entities ) {
        setList(entities);
    }

    private void setList(List<ItemEntity> entities) {
        this.entities = entities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder((TextView) view.findViewById(android.R.id.text1));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ItemEntity entity = entities.get(position);
        holder.textView.setText(entity.title);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }
}
