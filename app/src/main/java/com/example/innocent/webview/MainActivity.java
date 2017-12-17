package com.example.innocent.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                if(!Common.connectionAvailable(MainActivity.this)){
                    Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
                    intent.putExtra("MSG", "Please check internet connection");
                    startActivity(intent);
                    finish();

                }


            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
                intent.putExtra("MSG", "Something went wrong");
                startActivity(intent);
                finish();
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.loadUrl("http://wired.com");
    }

    @Override
    public void onBackPressed() {
        WebView webView = (WebView)findViewById(R.id.webview);
        if(webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }
}
