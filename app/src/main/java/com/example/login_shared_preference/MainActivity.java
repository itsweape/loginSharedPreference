package com.example.login_shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String mail = "admin@gmail.com";
    String pass = "admin123";

    EditText email, password;
    Button btnLogin;
    boolean login = false;

    private SharedPreferences SharedPref;
    private final String sharedPrefFile = "com.example.sharedpreferenceapp";

    private final String LOGIN_KEY = "login-key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPref = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);

        login = SharedPref.getBoolean(LOGIN_KEY, false);

        if (login){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.getText().toString().equals(mail)&&password.getText().toString().equals(pass)){
                    login = true;
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    saveLogin();
                    startActivity(intent);
                } else{
                    email.setText("");
                    password.setText("");
                }
            }
        });
    }

    private void saveLogin(){
        SharedPreferences.Editor editor = SharedPref.edit();
        editor.putBoolean(LOGIN_KEY, login);
        editor.apply();
    }
}