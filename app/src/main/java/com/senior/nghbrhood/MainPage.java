package com.senior.nghbrhood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity implements androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //TextView dateTime = (TextView) findViewById(R.id.dataTime);

        //hiding status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //hide the title bar
        getSupportActionBar().hide();

        //dateTime.setText(String.valueOf(java.util.Calendar.getInstance().getTime()));


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.listShopsBtn:
                Intent intent = new Intent(getApplicationContext(), ListShops.class);
                startActivity(intent);
                break;
            case R.id.chatBtn:
                Intent intent2 = new Intent(getApplicationContext(), chat.class);
                startActivity(intent2);
                break;
            /*case R.id.billsBtn:
                Intent intent3 = new Intent(getApplicationContext(), bills.class);
                startActivity(intent3);
                break;*/
        }
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    public void showPopupBills(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.bill_popup);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.changePassword:
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                Intent intent = new Intent(this, ChangePassword.class);
                startActivity(intent);
                return true;
            case R.id.logout:
                SharedPreferences preferences2 = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor2 = preferences2.edit();
                editor2.putString("remember", "false");
                editor2.apply();
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.addbills:
                Intent intent2 = new Intent(this, addbill.class);
                startActivity(intent2);
                return true;
            case R.id.showbills:
                Intent intent3 = new Intent(getApplicationContext(), bills.class);
                startActivity(intent3);
                return true;
            default:
                return false;
        }
    }

    public boolean onMenuItemClick2(MenuItem item) {
        switch (item.getItemId()) {

            default:
                return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void browser1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://94.103.47.43:3000/home"));
        startActivity(browserIntent);
    }
}