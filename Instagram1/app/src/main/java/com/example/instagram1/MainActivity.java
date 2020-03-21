package com.example.instagram1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.instagram1.MyAdapter.listItems;

public class MainActivity extends AppCompatActivity implements MyAdapter.onNoteListener {
    private RecyclerView recyclerView;
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
        RecyclerView.Adapter adapter = new MyAdapter(images,this);
        recycler_view.setAdapter(adapter);
    }

    boolean liked;

    public void pressLike(View view)
    {
        TextView tvLike=findViewById(R.id.likes_number);
        ImageView like = findViewById(R.id.like_image);
        String likes = (String) tvLike.getText();
        int likes_num = Integer.parseInt(likes);
        if(!liked)
        {
            likes_num++;
            like.setImageResource(R.drawable.ic_favorite_black);
            liked=true;
            tvLike.setText(Integer.toString(likes_num));
        }
        else {
            likes_num--;
            like.setImageResource(R.drawable.ic_favorite);
            liked=false;
            tvLike.setText(Integer.toString(likes_num));
        }

    }
    public void pressComment(View view)
    {
        Intent myIntent = new Intent(MainActivity.this, Comment.class);
        startActivity(myIntent);

    }

    @Override
    public void onClick(int position) {
        TextView tvLike=findViewById(R.id.likes_number);
        String s =(String) tvLike.getText();
        Intent intent = new Intent(this,Comment.class);
        Bundle bundle=new Bundle();
        Bundle bundle1=new Bundle();
        bundle.putInt("image",images[position]);
        intent.putExtras(bundle);
        bundle.putString("like",s);
        intent.putExtra("like",s);
        startActivity(intent);
    }
}
