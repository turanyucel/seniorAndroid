package com.senior.nghbrhood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bills extends AppCompatActivity {

    private WebView SecondwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        //hiding status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //hide the title bar
        getSupportActionBar().hide();

        SecondwebView=(WebView) findViewById(R.id.webviewBills2);
        SecondwebView.setWebViewClient(new bills.load());
        SecondwebView.getSettings().setJavaScriptEnabled(true);
        SecondwebView.loadUrl("https://www.faturamatik.com.tr/tr/hizmetlerimiz/fatura-ode#menu0");
    }

    public class load extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(SecondwebView.canGoBack()) {
            SecondwebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}