package com.tjoeun.etcview0626;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebViewActivity extends AppCompatActivity {
    Button daum, local;
    WebView webView;

    class MyWebClient extends WebViewClient{
        @Override
        public void onPageStarted(
               WebView view, String url, Bitmap favicon){
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        daum = (Button)findViewById(R.id.daum);
        local = (Button)findViewById(R.id.local);
        webView = (WebView)findViewById(R.id.webview);
        //WebView의 옵션 설정
        //리다이렉트 되는 페이지의 이동을 WebView가 처리하도록 설정
        webView.setWebViewClient(new WebViewClient());

        //자바스크립트와 화면 크기 변화를 가능하도록 하는 옵션
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);

        //WebView의 URL Load
        webView.loadUrl("https://www.google.com");

        daum.setOnClickListener((view) ->{
         webView.loadUrl("https://www.youtube.com");
        });

        local.setOnClickListener((viwe)->{
            webView.loadUrl("file:///android_asset/test.html");
        });

    }
}
