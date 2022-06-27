package com.cultive.monitore;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class luminosidade extends AppCompatActivity {

    TextView txt;
    TextView txt2;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    //FirebaseFirestore db2 = FirebaseFirestore.getInstance();

    private DatabaseReference bancoDataref;
    private DatabaseReference bancoDataref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        getSupportActionBar().hide();

        bancoDataref = FirebaseDatabase.getInstance().getReference().child("Teste");
        bancoDataref2 = FirebaseDatabase.getInstance().getReference().child("Teste2");


        txt = findViewById(R.id.test);
        txt2 = findViewById(R.id.test2);

        bancoDataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    String data = snapshot.getValue().toString();
                    txt.setText(data);

                    String sol = "Ensolarado";
                    String nub = "Nublado";

                    int lum = Integer.parseInt(data);
                    if(lum <= 700){
                        txt2.setText(sol);
                    }
                    else{
                        txt2.setText(nub);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*bancoDataref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    String data = snapshot.getValue().toString().substring(22);
                    txt2.setText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        /*bancoDataref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        String data = dataSnapshot.getValue().toString();
                        txt2.setText(data);
                }*

                Log.d(TAG, "Number: " + dataSnapshot.getChildrenCount());

                for(DataSnapshot ignored: dataSnapshot.getValue())
                {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String data = snapshot.getValue().toString();
                txt2.setText(data);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };*/
    }
}
