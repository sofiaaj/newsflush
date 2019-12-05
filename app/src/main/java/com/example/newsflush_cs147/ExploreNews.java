package com.example.newsflush_cs147;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class ExploreNews extends AppCompatActivity {

    ArrayList<News> newsList;
    ArrayList<String> userCategory;
    Integer userTime = 5;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_news);
        ivBack = findViewById(R.id.ivBack);
        setButtonListener();
        newsList = new ArrayList<>();
        userCategory = (ArrayList<String>) getIntent().getSerializableExtra("categories");
        String time = getIntent().getStringExtra("time");
        if(time.equals("Taco")){
            userTime = 10;
        } else if(time.equals("Boss")){
            userTime = 15;
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RecyclerView rvNews = findViewById(R.id.rvNews);
        ArrayList<News> allNews = News.createNewsList();
        for(News curr : allNews){
            if(userCategory.contains(curr.getCategory()) || Integer.valueOf(curr.getTime()) <= userTime){
                newsList.add(curr);
            }
        }
        Collections.shuffle(newsList);
        NewsAdapter newsAdapter = new NewsAdapter(newsList);
        rvNews.setAdapter(newsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        rvNews.setLayoutManager(layoutManager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setButtonListener(){
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExploreNews.this, SelectTime.class);
                intent.putExtra("categories", userCategory);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
