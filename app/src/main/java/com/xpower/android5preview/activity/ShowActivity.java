package com.xpower.android5preview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.xpower.android5preview.R;

/**
 * Created by 4399-3040 on 2016/7/25.
 */
public class ShowActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private WebView mWebView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mWebView = (WebView) findViewById(R.id.show_webview);
        mProgressBar = (ProgressBar) findViewById(R.id.show_progressbar);
        mProgressBar.setVisibility(View.VISIBLE);

        mWebView.loadUrl("http://www.4399.com");
        mToolBar.setTitle("4399小游戏");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
