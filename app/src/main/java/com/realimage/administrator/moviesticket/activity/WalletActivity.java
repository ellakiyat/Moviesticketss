package com.realimage.administrator.moviesticket.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.realimage.administrator.moviesticket.R;

public class WalletActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.id_wallettbar);
        /*setSupportActionBar(toolbar);*/
        webView = (WebView) findViewById(R.id.walletWebview);
        webView.loadUrl("https://www.moviepass.io/dialog/authorize?redirect_uri=https://localhost:3000&response_type=code&client_id=justickets&scope=offline_access");
    }
}
