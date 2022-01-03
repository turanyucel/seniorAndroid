package com.senior.nghbrhood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ListShops extends AppCompatActivity {

    private WebView mywebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_shops);

        //hiding status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //hide the title bar
        getSupportActionBar().hide();

        mywebView=(WebView) findViewById(R.id.webviewBills2);
        mywebView.setWebViewClient(new ListShops.load());
        mywebView.getSettings().setJavaScriptEnabled(true);
        mywebView.loadUrl("https://www.google.com/maps/search/Markets/@39.8668454,32.744345,15z/data=!3m1!4b1?hl=en");
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
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn4:
                Intent intent2 = new Intent(getApplicationContext(), chat.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}