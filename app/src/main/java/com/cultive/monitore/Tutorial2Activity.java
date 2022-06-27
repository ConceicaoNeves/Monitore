package com.cultive.monitore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tutorial2Activity extends AppCompatActivity {
    Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);

        getSupportActionBar().hide();

        bt3 = (Button) findViewById(R.id.button3);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tutorial2Activity.this,
                        Tutorial3Activity.class);
                startActivity(i);
            }
        });
    }
}