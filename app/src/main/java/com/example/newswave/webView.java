package com.example.newswave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.View;

public class webView extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar=findViewById(R.id.toolbar);
        webView=findViewById(R.id.webView);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent != null) {
            String url = intent.getStringExtra("url");
            if (url != null && !url.isEmpty()) {
                webView.clearCache(true);
                webView.setWebViewClient(new WebViewClient());
                webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(url);
            }
        }

    }
}