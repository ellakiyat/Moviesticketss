package com.realimage.administrator.moviesticket.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.realimage.administrator.moviesticket.R;


public class PpolicyActivity extends AppCompatActivity {

    WebView wv;
    private ProgressDialog progressbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestwindowfeature method of activity to call hide the title
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_policy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_purctoolbar);
        wv = (WebView) findViewById(R.id.purpolicyWebview);


        if (isNetworkAvailable()) {

            startWebview("https://static.justickets.in/purchase_policy.html");

        } else {


            Toast.makeText(getApplicationContext(), "Check Internet connection", Toast.LENGTH_SHORT).show();

        }

    }

    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    private void startWebview(String url) {

        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        //zomm of the web page
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        progressbar = new ProgressDialog(this);
        progressbar.setMessage("Loading....");
        progressbar.show();

        wv.setWebViewClient(new WebViewClient() {

            //Is it called during initial loading of url
            //Is it called everytime URL of webview changes?
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

//while the webpage is loading finished to callback onPagefinished()

            @Override
            public void onPageFinished(WebView view, String url) {

                if (progressbar.isShowing()) {
                    progressbar.dismiss();
                }
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

                Toast.makeText(PpolicyActivity.this, "Error:" + "webpage loading error.. ", Toast.LENGTH_SHORT).show();

            }
        });
        wv.loadUrl(url);

    }
}

