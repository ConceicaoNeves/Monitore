package com.cultive.monitore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Tutorial1Activity extends AppCompatActivity {
    Button bt2;
    GoogleSignInOptions gop;
    GoogleSignInClient goc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial1);

        gop = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        goc = GoogleSignIn.getClient(this,gop);

        bt2 = (Button) findViewById(R.id.button2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tutorial1Activity.this,
                        Tutorial2Activity.class);
                startActivity(i);
            }
        });
    }
}