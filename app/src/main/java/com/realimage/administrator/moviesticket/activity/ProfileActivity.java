package com.realimage.administrator.moviesticket.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.realimage.administrator.moviesticket.R;
public class ProfileActivity extends AppCompatActivity {

    WebView webView;
    private ProgressDialog progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_profile);
        webView = (WebView) findViewById(R.id.prfWebView);
        if (isNetworkAvailable()) {

            startWebview("https://www.moviepass.io/dialog/authorize?redirect_uri=https://localhost:3000&response_type=code&client_id=justickets&scope=offline_access");

        } else {

            Toast.makeText(getApplicationContext(), "No network connection", Toast.LENGTH_SHORT).show();

        }
    }

    private void startWebview(String url) {

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        //zomm of the web page
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        progressbar = new ProgressDialog(this);
        progressbar.setMessage("Loading....");
        progressbar.show();

        webView.setWebViewClient(new WebViewClient() {

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

                Toast.makeText(ProfileActivity.this, "Error:" + "webpage loading error.. ", Toast.LENGTH_SHORT).show();

            }
        });
        webView.loadUrl(url);

    }

    private boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
