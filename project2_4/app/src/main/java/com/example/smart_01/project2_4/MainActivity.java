package com.example.smart_01.project2_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id찾기
        web = (WebView) findViewById(R.id.webView1);

        web.loadUrl("file:///android_asset/test.html");
    }
}
