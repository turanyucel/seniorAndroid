package com.senior.nghbrhood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class ChangePassword extends AppCompatActivity {

    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        //hiding status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //hide the title bar
        getSupportActionBar().hide();
    }

    /*public void onClick(View v){
        Intent intent = null;
        switch(v.getId()){
            case R.id.cancelTv3:
                intent = new Intent(this, MainPage.class);
                break;
            case R.id.loginBtn3:
                intent = new Intent(this, MainActivity.class);
                Toast.makeText(this, "Your password is successfully changed.", Toast.LENGTH_SHORT).show();
                break;
        }
        if (null!=intent) startActivity(intent);
    }*/

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn3:
                final EditText textInputEditTextUserName = (EditText) findViewById(R.id.userNamePt2);
                final EditText textInputEditTextPassword = (EditText) findViewById(R.id.passwordPt6);

                username = textInputEditTextUserName.getText().toString();
                password = textInputEditTextPassword.getText().toString();


                if (!username.equals("")  && !password.equals("")) {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            PutData putData = new PutData("http://192.168.0.195/LoginRegister/update.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Update Failed")) {
                                        Toast.makeText(getApplicationContext(), "Your password is successfully changed", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "All the Fields are Required", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cancelTv3:
                Intent intent2 = new Intent(getApplicationContext(), MainPage.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}