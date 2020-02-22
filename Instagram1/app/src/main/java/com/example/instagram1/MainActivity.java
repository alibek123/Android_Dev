package com.example.instagram1;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<Listitem> listItems = new ArrayList<>();
    private int[] images=new int[]{
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
        R.drawable.img7,
        R.drawable.img8,
        R.drawable.img9,
        R.drawable.img10,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        RecyclerView recycler_view = findViewById((R.id.recycler_view));
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        adapter= new MyAdapter(images);
        recycler_view.setAdapter(adapter);



    }



    public void pressLike(View view)
    {
        boolean liked=false;
        ImageView like = findViewById(R.id.like_image);
        if(liked==false)
        {
            like.setImageResource(R.drawable.ic_favorite_black);
            liked=true;
        }
        else {
            like.setImageResource(R.drawable.ic_favorite);
            liked=false;
        }
    }
}
