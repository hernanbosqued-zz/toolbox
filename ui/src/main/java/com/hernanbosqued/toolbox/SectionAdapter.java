package com.hernanbosqued.toolbox;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hernanbosqued.toolbox.domain.SectionEntity;

import java.util.List;

class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder> {

    private List<SectionEntity> entities;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;

        public ViewHolder(View view) {
            super(view);
            this.textView = view.findViewById(R.id.titulo);
            this.recyclerView = view.findViewById(R.id.items_recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        }
    }

    public SectionAdapter(List<SectionEntity> entities ) {
        setList(entities);
    }

    private void setList(List<SectionEntity> entities) {
        this.entities = entities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_section, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SectionEntity entity = entities.get(position);
        holder.textView.setText(entity.title);
        holder.recyclerView.setAdapter(new ItemsAdapter(entity.items));
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
