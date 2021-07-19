package com.example.govtpolyamravati;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Student_Payment extends AppCompatActivity {
    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__payment);
        mywebView=(WebView) findViewById(R.id.webview);
        Toast.makeText(getApplicationContext(), "Please wait for few seconds until website is load", Toast.LENGTH_LONG).show();
        WebSettings websettings=mywebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("https://www.onlinesbi.com/error404.html?corpID=672107");
        mywebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(mywebView.canGoBack()){
            mywebView.goBack();
        }
        else
            super.onBackPressed();
    }
}
