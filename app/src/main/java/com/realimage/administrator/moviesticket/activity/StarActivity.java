package com.realimage.administrator.moviesticket.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.realimage.administrator.moviesticket.R;
public class StarActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        webView= (WebView) findViewById(R.id.starWebview);

     webView.loadUrl("https://play.google.com/store/apps/details?id=in.justickets.android&hl=en");

    }
}
