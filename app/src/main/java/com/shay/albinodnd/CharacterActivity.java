package com.shay.albinodnd;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CharacterActivity extends AppCompatActivity {

    private ArrayList<Character> characters = new ArrayList<>();
    private DatabaseReference databaseReference;
    private ValueEventListener databaseReferenceListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReferenceListener = databaseReference.child("characters").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    characters.add(postSnapshot.getValue(Character.class));
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseReference.removeEventListener(databaseReferenceListener);
    }



}
