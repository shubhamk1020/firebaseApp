package com.mastercoding.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Write Message to database;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

    //    myRef.setValue("Hello, Maser Coding Channel");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

              /*  //Here we want to execute  code when receiving data;
                // single data

               //  String s = (String) dataSnapshot.getValue();
                //textView.setText(s);

                // Here we want to multiple data receiving

                Log.v("Taggy","" + dataSnapshot.getValue());

                Log.v("Taggy",""+ databaseList().length);
                */
                //For loop inorder to get each snapshot

                if(dataSnapshot.getValue() != null){
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        String k = "" + snapshot.getKey();
                        Log.v("Taggy"," " + k);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}