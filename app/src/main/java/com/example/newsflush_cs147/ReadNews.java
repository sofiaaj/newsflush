package com.example.newsflush_cs147;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

public class ReadNews extends AppCompatActivity {

    String article;
    String headline;
    ArrayList<String> mNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_news);
        headline = getIntent().getStringExtra("headline");
        article = getIntent().getStringExtra("article");
        final String category = getIntent().getStringExtra("category");
        TextView tvArticle = findViewById(R.id.tvArticle);
        TextView tvHeadline = findViewById(R.id.tvHeadline);
        ImageView ivBack = findViewById(R.id.ivBackArrow);
        tvArticle.setText(article);
        tvHeadline.setText(headline);
        tvArticle.setMovementMethod(new ScrollingMovementMethod());
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/html");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>This is the text shared.</p>"));
                if (sharingIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(sharingIntent,"Share using"));
                }
            }
        });

    }


}
