package com.cultive.monitore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal1Activity extends AppCompatActivity {
    Button bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal1);

        bt5 = (Button) findViewById(R.id.button5);

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal1Activity.this,
                        Temp.class);
                startActivity(i);
            }
        });
    }


}