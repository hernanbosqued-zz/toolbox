package com.hernanbosqued.toolbox;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;
import com.hernanbosqued.toolbox.domain.Item;

public class ItemViewHolder extends BaseViewHolder<Item> {
    private TextView textView;
    private ImageView imageView;
    private OnItemClickListener listener;
    private Item item;

    ItemViewHolder(View view, OnItemClickListener listener) {
        super(view);
        this.textView = view.findViewById(R.id.titulo);
        this.imageView = view.findViewById(R.id.imagen);
        this.listener = listener;
    }

    @Override
    public void bind(final Item item) {
        this.item = item;
        this.textView.setText(item.title);
        this.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(ItemViewHolder.this.item);
            }
        });
        Glide.with(imageView.getContext())
            .load(item.url)
            .asBitmap()
            .signature(new StringSignature(String.valueOf(imageView.hashCode())))
            .into(imageView);
    }

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }
}
