package com.example.newsflush_cs147;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SelectTime extends AppCompatActivity {

    public final String KEY_TIME = "time";
    public ArrayList<String> userCategory;
    Toolbar toolbar;

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
        userCategory = (ArrayList<String>) getIntent().getSerializableExtra("categories");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setUserListeners();

    }

    public void onButtonShowPopupWindowClick(View item) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(toolbar, Gravity.TOP|Gravity.RIGHT, 45, 45);
        TextView tvZipcode = popupView.findViewById(R.id.tvZipcode);
        TextView tvInterests = popupView.findViewById(R.id.tvInterests);
        TextView tvCancel = popupView.findViewById(R.id.tvCancel);
        tvZipcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTime.this, UserZipcode.class);
                startActivity(i);
            }
        });
        tvInterests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectTime.this, SelectInterests.class);
                startActivity(i);
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken


        // dismiss the popup window when touched
//        popupView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                popupWindow.dismiss();
//                return true;
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

    }


    private void setUserListeners(){
        final ImageView ivSalad = findViewById(R.id.ivSalad);
        final ImageView ivTaco = findViewById(R.id.ivTaco);
        final ImageView ivBoss = findViewById(R.id.ivBoss);
        ConstraintLayout clLayout = findViewById(R.id.clLayout);
        ivSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == ivSalad){
                    Intent intent = new Intent(SelectTime.this, ExploreNews.class);
                    intent.putExtra(KEY_TIME, "salad");
                    intent.putExtra("categories", userCategory);
                    startActivity(intent);
                }
            }
        });
        ivTaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == ivTaco){
                    Intent intent = new Intent(SelectTime.this, ExploreNews.class);
                    intent.putExtra(KEY_TIME, "taco");
                    intent.putExtra("categories", userCategory);
                    startActivity(intent);

                }
            }
        });
        ivBoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == ivBoss){
                    Intent intent = new Intent(SelectTime.this, ExploreNews.class);
                    intent.putExtra(KEY_TIME, "boss");
                    intent.putExtra("categories", userCategory);
                    startActivity(intent);
                }
            }
        });


    }
}
