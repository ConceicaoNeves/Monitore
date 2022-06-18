package com.cultive.monitore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial3Activity extends AppCompatActivity {
    Button bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial3);

        bt4 = findViewById(R.id.button4);

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tutorial3Activity.this,
                        HomeActivity.class);
                startActivity(i);
            }
        });
    }
}