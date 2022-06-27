package com.cultive.monitore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FirstActivity extends AppCompatActivity {


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        getSupportActionBar().hide();

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override public void run() {
                finish();
                Intent i = new Intent(FirstActivity.this,
                        HomeActivity.class);
                startActivity(i);
            }
        }, 2000);
        }



}