package com.example.newsflush_cs147;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class SelectTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView tvSelectTimeInstructions = findViewById(R.id.tvSelectTimeInstructions);
        String selectTimeInstructions = "<b>" + "How long " + "</b>" + "will you be pooping?";
        if(tvSelectTimeInstructions != null){
            tvSelectTimeInstructions.setText(Html.fromHtml(selectTimeInstructions));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setUserListeners();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private void setUserListeners(){
        final ImageView ivSalad = findViewById(R.id.ivSalad);
        ImageView ivTaco = findViewById(R.id.ivTaco);
        ImageView ivBoss = findViewById(R.id.ivBoss);
        ConstraintLayout clLayout = findViewById(R.id.clLayout);
        ivSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == ivSalad){
                    Intent intent = new Intent(SelectTime.this, ExploreNews.class);
                    startActivity(intent);
                }
            }
        });

    }
}
