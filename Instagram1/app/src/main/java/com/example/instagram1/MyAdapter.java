package com.example.instagram1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private int[] images;
    public MyAdapter(int[] images)
    {
        this.images=images;
    }
    private List<Listitem> listItems;
    private Context context;

    public MyAdapter(List<Listitem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image_id = images[position];
        holder.post_image.setImageResource(image_id);
        holder.tvLikes.setText("5"+position+"000");
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView post_image;
        TextView tvLikes;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            post_image= itemView.findViewById(R.id.post_image);
            tvLikes = itemView.findViewById(R.id.likes_number);
        }
    }



}
