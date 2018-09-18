package com.example.user.webbrowseer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=findViewById(R.id.web);

        WebSettings obj= web.getSettings();
        obj.setJavaScriptEnabled(true);

        web.loadUrl("https://www.learncodeonline.in");

        web.setWebViewClient(new WebViewClient());


    }

    @Override
    public void onBackPressed() {
            if(web.canGoBack()){
                web.goBack();
            }else{
                super.onBackPressed();
            }
    }
}
