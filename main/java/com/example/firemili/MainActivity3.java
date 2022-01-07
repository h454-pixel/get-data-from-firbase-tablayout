package com.example.firemili;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity3 extends AppCompatActivity {


    WebView webView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    webView = (WebView)findViewById(R.id.webvieww);
        webView.loadUrl("https://play.google.com/store/apps/details?id=eight.ball.blitz.pool.billiards.free.android");


    }
}