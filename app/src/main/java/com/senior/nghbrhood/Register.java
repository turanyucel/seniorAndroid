package com.senior.nghbrhood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Register extends AppCompatActivity {

    String username, name, surname, email, password, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //hiding status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //hide the title bar
        getSupportActionBar().hide();

        Spinner spin = (Spinner) findViewById(R.id.typeSpinner);

        spin.setSelection(0);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerBtn2:
            final EditText textInputEditTextUserName = (EditText) findViewById(R.id.userNamePt3);
            final EditText textInputEditTextName = (EditText) findViewById(R.id.namePt);
            final EditText textInputEditTextSurName = (EditText) findViewById(R.id.surnamePt);
            final EditText textInputEditTextEmail = (EditText) findViewById(R.id.passwordPt2);
            final EditText textInputEditTextPassword = (EditText) findViewById(R.id.passwordPt3);
            final EditText textInputEditTextAddress = (EditText) findViewById(R.id.addressPt);

            username = textInputEditTextUserName.getText().toString();
            name = textInputEditTextName.getText().toString();
            surname = textInputEditTextSurName.getText().toString();
            email = textInputEditTextEmail.getText().toString();
            password = textInputEditTextPassword.getText().toString();
            address = textInputEditTextAddress.getText().toString();


            if (!username.equals("") && !name.equals("") && !surname.equals("") && !email.equals("") && !password.equals("") && !address.equals("")) {
                //Start ProgressBar first (Set visibility VISIBLE)
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[6];
                        field[0] = "username";
                        field[1] = "name";
                        field[2] = "surname";
                        field[3] = "email";
                        field[4] = "password";
                        field[5] = "address";

                        String[] data = new String[6];
                        data[0] = username;
                        data[1] = name;
                        data[2] = surname;
                        data[3] = email;
                        data[4] = password;
                        data[5] = address;
                        PutData putData = new PutData("http://192.168.0.195/LoginRegister/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Sign Up Success")) {
                                    SharedPreferences preferences2 = getSharedPreferences("checkbox", MODE_PRIVATE);
                                    SharedPreferences.Editor editor2 = preferences2.edit();
                                    editor2.putString("remember", "false");
                                    editor2.apply();
                                    Toast.makeText(getApplicationContext(), "You are Successfully Signed", Toast.LENGTH_SHORT).show();
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
            case R.id.cancelTv2:
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}