package com.example.instagram1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comment);

        Bundle bundle = this.getIntent().getExtras();
        int pic =bundle.getInt("image");
        String like = bundle.getString("like");


        ImageView ivPost = findViewById(R.id.post_image);
        TextView tvLike = findViewById(R.id.likes_number);
        ivPost.setImageResource(pic);
        tvLike.setText(like);
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
        Intent myIntent = new Intent(Comment.this, MainActivity.class);
        startActivity(myIntent);

    }
}
