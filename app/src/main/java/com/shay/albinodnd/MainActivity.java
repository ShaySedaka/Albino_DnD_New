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


public class MainActivity extends AppCompatActivity {


    //Views
    Button btnLucian, btnFemina, btnHiretson, btnRig, btnMerlin, btnBreanne, btnCuahu, btnInigo;

    //Fields
    public static String mSelectedCharacter = "";
    public static int numOfCharacters = 8;
    private DatabaseReference databaseReference;
    private ValueEventListener databaseReferenceListener;
    public static ArrayList<Character> databaseCharacters = new ArrayList<>();

    private String getSelecterCharacter(){
        return mSelectedCharacter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReferenceListener = databaseReference.child(Consts.CHARACTERS)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            databaseCharacters.add(postSnapshot.getValue(Character.class));
                        }
                        getViews();
                        setListeners();
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

    private void getViews()
    {
        btnBreanne = findViewById(R.id.buttonBreanne);
        btnLucian = findViewById(R.id.buttonLucian);
        btnFemina = findViewById(R.id.buttonFemina);
        btnHiretson = findViewById(R.id.buttonHiretson);
        btnRig = findViewById(R.id.buttonRig);
        btnMerlin = findViewById(R.id.buttonMerlin);
        btnCuahu = findViewById(R.id.buttonCuahu);
        btnInigo = findViewById(R.id.buttonInigo);
    }

    private void setListeners(){
        btnLucian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = Consts.LUCIAN;
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnInigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = Consts.INIGO;
                MainActivity.this.startActivity(myIntent);
            }
        });


        btnCuahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = Consts.CUAHU;
                MainActivity.this.startActivity(myIntent);
            }
        });


        btnMerlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = Consts.MERLIN;
                MainActivity.this.startActivity(myIntent);
            }
        });


        btnHiretson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = Consts.HIRETSON;
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnFemina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = Consts.FEMINA;
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnBreanne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = Consts.BREANNE;
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnRig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = Consts.RIG;
                MainActivity.this.startActivity(myIntent);
            }
        });

    }

}
