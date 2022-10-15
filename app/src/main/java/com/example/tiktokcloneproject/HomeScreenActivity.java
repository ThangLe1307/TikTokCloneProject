package com.example.tiktokcloneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends Activity implements View.OnClickListener{

    private Button btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        btnProfile = (Button) findViewById(R.id.btnProfile);

        btnProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnProfile.getId())
        {
            Intent intent = new Intent(HomeScreenActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        }
    }
}