package com.realimage.administrator.moviesticket.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.realimage.administrator.moviesticket.R;


public class PripolicyActivity extends Activity {


    WebView wvpripolicy;
    private ProgressDialog progressbar;

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setContentView(R.layout.activity_pripolicy);

        wvpripolicy = (WebView) findViewById(R.id.pripolicyWebview);

        if (isNetworkAvailable()) {

            startWebview("https://static.justickets.in/privacy_policy.html");

        } else {

            Toast.makeText(getApplicationContext(), "No network connection", Toast.LENGTH_SHORT).show();

        }
    }


    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void startWebview(String url) {

        WebSettings webSettings = wvpripolicy.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvpripolicy.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        //zomm of the web page
        wvpripolicy.getSettings().setBuiltInZoomControls(true);
        wvpripolicy.getSettings().setUseWideViewPort(true);
        wvpripolicy.getSettings().setLoadWithOverviewMode(true);
        progressbar = new ProgressDialog(this);
        progressbar.setMessage("Loading....");
        progressbar.show();

        wvpripolicy.setWebViewClient(new WebViewClient() {

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

            // page not found or "page not loading error" in WebView?
            //receiveerror() should able to intercept

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

                Toast.makeText(PripolicyActivity.this, "Error:" + "webpage loading error.. ", Toast.LENGTH_SHORT).show();

            }
        });
        wvpripolicy.loadUrl(url);

    }
}
