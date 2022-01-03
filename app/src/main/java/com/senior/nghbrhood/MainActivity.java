package com.senior.nghbrhood;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ForgotYourPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button loginBtn = findViewById(R.id.loginBtn);
        final Button registerBtn = (Button) findViewById(R.id.RegisterBtn);

        //hiding status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //hide the title bar
        getSupportActionBar().hide();

        //forgotYourPassword Linking
        TextView forgotYourTv = (TextView) findViewById(R.id.forgotYourTv);
        forgotYourTv.setMovementMethod(LinkMovementMethod.getInstance());

        Intent intent = new Intent(this, Login.class);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        Intent intent2 = new Intent(this, Register.class);
        registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
    }
}