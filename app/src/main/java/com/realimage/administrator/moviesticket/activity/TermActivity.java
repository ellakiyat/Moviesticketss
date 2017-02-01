package com.realimage.administrator.moviesticket.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.realimage.administrator.moviesticket.R;

public class TermActivity extends Activity {
    WebView termwv;
    private ProgressDialog progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        termwv = (WebView) findViewById(R.id.termWebview);
        if (isNetworkAvailable()) {

            startWebview("https://static.justickets.in/terms.html");

        } else {

            Toast.makeText(getApplicationContext(), "No network connection", Toast.LENGTH_SHORT).show();
        }
    }

    private void startWebview(String url) {
        WebSettings webSettings = termwv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        termwv.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        //zomm of the web page
        termwv.getSettings().setBuiltInZoomControls(true);
        termwv.getSettings().setUseWideViewPort(true);
        termwv.getSettings().setLoadWithOverviewMode(true);
        progressbar = new ProgressDialog(this);
        progressbar.setMessage("Loading....");
        progressbar.show();

        termwv.setWebViewClient(new WebViewClient() {

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

                Toast.makeText(TermActivity.this, "Error:" + "webpage loading error.. ", Toast.LENGTH_SHORT).show();
            }
        });
        termwv.loadUrl(url);
    }

    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
