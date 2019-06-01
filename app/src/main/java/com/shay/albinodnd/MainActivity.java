package com.shay.albinodnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {


    //Views
    Button btnLucian, btnFemina, btnHiretson, btnRig, btnMerlin, btnBreanne, btnCuahu, btnInigo;

    //Fields
    public static String mSelectedCharacter = "";
    public static int numOfCharacters = 8;

    private String getSelecterCharacter(){
        return mSelectedCharacter;
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
                mSelectedCharacter = "Lucian";
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnInigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = "Inigo";
                MainActivity.this.startActivity(myIntent);
            }
        });


        btnCuahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = "Cuahu";
                MainActivity.this.startActivity(myIntent);
            }
        });


        btnMerlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = "Merlin";
                MainActivity.this.startActivity(myIntent);
            }
        });


        btnHiretson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = "Hiretson";
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnFemina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = "Lady Femina";
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnBreanne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = "Breanne";
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnRig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class);
                mSelectedCharacter = "Rig";
                MainActivity.this.startActivity(myIntent);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        setListeners();
    }
}
