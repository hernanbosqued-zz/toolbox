package com.hernanbosqued.toolbox;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hernanbosqued.toolbox.domain.Section;

public abstract class BaseViewHolder<M> extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    abstract void bind(M section);
}
