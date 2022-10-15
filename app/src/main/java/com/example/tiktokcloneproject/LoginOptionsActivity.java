package com.example.tiktokcloneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.os.Bundle;

public class LoginOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options);
    }

    public void emailLogInPage(View view) {
        Intent intent = new Intent(LoginOptionsActivity.this, EmailLogInActivity.class);
        startActivity(intent);
    }
}