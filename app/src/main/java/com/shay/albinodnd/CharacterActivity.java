package com.shay.albinodnd;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CharacterActivity extends AppCompatActivity {

    //Fields
    public static String mSelectedOption = "";
    public static ArrayList<Character> characters = new ArrayList<>();
    private DatabaseReference databaseReference;
    private ValueEventListener databaseReferenceListener;

    private String getSelecterOption(){
        return mSelectedOption;
    }


    //Views
    Button btnInventory, btnSkill, btnAttribute;


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

        getViews();
        setListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseReference.removeEventListener(databaseReferenceListener);
    }

    private void getViews()
    {
        btnInventory = findViewById(R.id.button_character_inventory);
        btnSkill = findViewById(R.id.button_character_skills);
        btnAttribute = findViewById(R.id.button_character_attributes);
    }

    private void setListeners() {
        btnInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CharacterActivity.this, ListActivity.class);
                mSelectedOption = "inventory";
                CharacterActivity.this.startActivity(myIntent);
            }
        });

        btnSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CharacterActivity.this, ListActivity.class);
                mSelectedOption = "skills";
                CharacterActivity.this.startActivity(myIntent);
            }
        });

        btnAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CharacterActivity.this, ListActivity.class);
                mSelectedOption = "attributes";
                CharacterActivity.this.startActivity(myIntent);
            }
        });
    }

}
