package com.hernanbosqued.toolbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hernanbosqued.toolbox.domain.Section;


class SectionAdapter extends BaseAdapter<Section, SectionViewHolder> {

    private ItemViewHolder.OnItemClickListener listener;

    SectionAdapter( ItemViewHolder.OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public SectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_section, parent, false);
        return new SectionViewHolder(view, listener);
    }
}
