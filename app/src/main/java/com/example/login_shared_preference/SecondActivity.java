package com.example.login_shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button btnLogout;
    private SharedPreferences SharedPref;
    private final String sharedPrefFile = "com.example.sharedpreferenceapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPref = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        btnLogout= findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearLogin();
                finish();
            }
        });
    }

    private void clearLogin(){
        SharedPreferences.Editor editor = SharedPref.edit();
        editor.clear();
        editor.apply();
    }
}