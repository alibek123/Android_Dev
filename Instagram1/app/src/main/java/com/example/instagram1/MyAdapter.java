package com.example.instagram1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private int[] images;
    private onNoteListener mOnNoteListener;
    MyAdapter(int[] images, onNoteListener onNoteListener)
    {
        this.images=images;
        mOnNoteListener=onNoteListener;
    }
    static List<Listitem> listItems;
    private Context context;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view,mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image_id = images[position];
        holder.post_image.setImageResource(image_id);
        Random random = new Random(1000);
       holder.tvLikes.setText(Integer.toString(random.nextInt(position+110000)));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView post_image;
        TextView tvLikes;
        onNoteListener onNoteListener;

        private ViewHolder(@NonNull View itemView, onNoteListener onNoteListener) {
            super(itemView);
            post_image= itemView.findViewById(R.id.post_image);
            tvLikes = itemView.findViewById(R.id.likes_number);
            this.onNoteListener=onNoteListener;
            itemView.setOnClickListener(this);
            context=itemView.getContext();
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onClick(getAdapterPosition());
        }
    }
    public interface onNoteListener {
        void onClick(int position);
    }



}
