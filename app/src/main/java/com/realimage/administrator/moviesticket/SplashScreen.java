package com.realimage.administrator.moviesticket;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.TextView;

import com.realimage.administrator.moviesticket.activity.MainActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        TextView splashtxt = (TextView) findViewById(R.id.splashextview);
        String splash = splashtxt.getText().toString();
        SpannableString spannableString = new SpannableString(splash);
        spannableString.setSpan(Typeface.BOLD, 0, splash.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        splashtxt.setText(spannableString);
        //SPLASH SCREEN RUN IN THREE SECOND
        Thread timerThread = new Thread() {

            public void run() {

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    Intent splash = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(splash);
                }

            }

        };

        timerThread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}
