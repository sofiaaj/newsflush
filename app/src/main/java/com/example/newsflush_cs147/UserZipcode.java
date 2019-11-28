package com.example.newsflush_cs147;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class UserZipcode extends AppCompatActivity {

    private Handler mWaitHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_zipcode);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView tvZipcodeInstructions = findViewById(R.id.tvZipcodeInstructions);
        String instructions = "Tell us" + "<b>" + " where " + "</b>" + "you are registered to poop." + "<b>" + " Lock the door when you’re done!" + "</b";
        if(tvZipcodeInstructions!=null){
            tvZipcodeInstructions.setText(Html.fromHtml(instructions));
        }
        monitorUserInput();
    }

    private void monitorUserInput(){
        final ImageView lock = (ImageView)findViewById(R.id.ivVacant);
        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lock.setVisibility(View.INVISIBLE);
                mWaitHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        //The following code will execute after the 5 seconds.

                        try {

                            //Go to next page i.e, start the next activity.
                            Intent intent = new Intent(UserZipcode.this, SelectInterests.class);
                            startActivity(intent);

                            //Let's Finish Splash Activity since we don't want to show this when user press back button.
                            finish();
                        } catch (Exception ignored) {
                            ignored.printStackTrace();
                        }
                    }
                }, 10);  // Give a 5 seconds delay.
            }

        });
    }
}
