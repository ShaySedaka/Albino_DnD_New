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
    String mSelectedCharacter = "";


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
