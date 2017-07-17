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
        this.textView = view.findViewById(R.id.title);
        this.imageView = view.findViewById(R.id.image);
        this.listener = listener;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( ItemViewHolder.this.item.video == null || ItemViewHolder.this.item.video.isEmpty() ){
                    ItemViewHolder.this.listener.showNoVideo();
                }
                else{
                    ItemViewHolder.this.listener.onItemClick(ItemViewHolder.this.item);
                }
            }
        });
    }

    @Override
    public void bind(final Item item) {
        this.item = item;
        this.textView.setText(item.title);
        Glide.with(imageView.getContext())
            .load(item.url)
            .signature(new StringSignature(String.valueOf(imageView.hashCode())))
            .into(imageView);
    }

    public interface OnItemClickListener {
        void onItemClick(Item item);

        void showNoVideo();
    }
}
