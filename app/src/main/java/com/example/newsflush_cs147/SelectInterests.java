package com.example.newsflush_cs147;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Boolean.TRUE;

public class SelectInterests extends AppCompatActivity {

    ArrayList<Button> allInterests;
    Button btnTech;
    Button btnPolitics;
    Button btnSports;
    Button btnArt;
    Button btnBusiness;
    Button btnScience;
    Button btnHealth;
    Button btnLocal;
    Button btnClimate;
    HashMap<Button, TranslateAnimation> allAnimations;
    ArrayList<String> userCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_interests);
        userCategory = new ArrayList<>();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView tvInterestInstructions = findViewById(R.id.tvInterestInstructions);
        String interestInstructions = "Tap to select the topics you are interested in. " + "<b>" + "Flush when you are done." + "</b>";
        if(tvInterestInstructions != null){
            tvInterestInstructions.setText(Html.fromHtml(interestInstructions));
        }
        makeButtonArray();
        seeUserInterests();
        makeAnimationHashmap();
        addToiletListeners();
    }

    private void makeAnimationHashmap(){
        allAnimations = new HashMap<>();
        int x = 0;
        int y = 2000;
        for(final Button curr : allInterests){
            if(curr == btnTech || curr == btnArt || curr == btnHealth){
                x = 300;
            } else if(curr == btnSports || curr == btnScience || curr == btnClimate){
                x = -300;
            } else {
                x = 0;
            }
            TranslateAnimation animation = new TranslateAnimation(0, x,0, y);
            animation.setDuration(800);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    for(final Button curr : allInterests){
                        if(!curr.isSelected()){
                            curr.setVisibility(View.INVISIBLE);
                        }

                    }

                        Intent intent = new Intent(SelectInterests.this, SelectTime.class);
                        intent.putExtra("categories", userCategory);
                        startActivity(intent);


                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            allAnimations.put(curr, animation);
        }
    }

    private void addToiletListeners(){
        ImageView ivToilet = findViewById(R.id.ivToilet);
        ivToilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userCategory.size() <= 0){
                    Toast.makeText(getApplicationContext(), "Please select at least one interest", Toast.LENGTH_LONG).show();
                }else {

                    for (final Button curr : allInterests) {
                        if (!curr.isSelected()) {
                            TranslateAnimation anim = allAnimations.get(curr);
                            curr.startAnimation(anim);
                            if (anim.hasEnded()) {
                                curr.setVisibility(View.INVISIBLE);
                            }
                        }
                    }

                }


            }
        });
    }

    private void makeButtonArray(){
        allInterests = new ArrayList<>();
        btnTech = findViewById(R.id.btnTech);
        btnPolitics = findViewById(R.id.btnPolitics);
        btnSports = findViewById(R.id.btnSports);
        btnArt = findViewById(R.id.btnArt);
        btnBusiness = findViewById(R.id.btnBusiness);
        btnScience = findViewById(R.id.btnScience);
        btnHealth = findViewById(R.id.btnHealth);
        btnLocal = findViewById(R.id.btnLocal);
        btnClimate = findViewById(R.id.btnClimate);
        allInterests.add(btnTech);
        allInterests.add(btnPolitics);
        allInterests.add(btnSports);
        allInterests.add(btnArt);
        allInterests.add(btnBusiness);
        allInterests.add(btnScience);
        allInterests.add(btnHealth);
        allInterests.add(btnLocal);
        allInterests.add(btnClimate);
    }

    private void seeUserInterests(){
        for(final Button curr : allInterests){
            curr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(curr.isSelected()){
                        curr.setSelected(false);
                        String category = curr.getText().toString();
                        userCategory.remove(category);
                    } else {
                        curr.setSelected(true);
                        String category = curr.getText().toString();
                        userCategory.add(category);
                    }
                }
            });
        }
    }


}
