package com.hernanbosqued.toolbox;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.hernanbosqued.toolbox.domain.Section;

public class SectionViewHolder extends BaseViewHolder<Section>{
    private final ItemViewHolder.OnItemClickListener listener;
    private TextView textView;
    private RecyclerView recyclerView;

    public SectionViewHolder(View view, ItemViewHolder.OnItemClickListener listener) {
        super(view);
        this.listener = listener;
        this.textView = view.findViewById(R.id.titulo);
        this.recyclerView = view.findViewById(R.id.items_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    public void bind(Section section) {
        textView.setText(section.title);
        ItemsAdapter adapter = new ItemsAdapter(listener);
        adapter.setData(section.items);
        recyclerView.setAdapter(adapter);
    }
}
