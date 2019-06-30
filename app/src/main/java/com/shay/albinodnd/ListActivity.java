package com.shay.albinodnd;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<GeneralListItem> generalList = new ArrayList<>();
    private DatabaseReference databaseReference;
    private ValueEventListener listDatabaseReferenceListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));

        databaseReference = FirebaseDatabase.getInstance().getReference();
        listDatabaseReferenceListener = databaseReference.child(Consts.CHARACTERS).
                child(MainActivity.mSelectedCharacter).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                CharacterActivity.currCharacter = dataSnapshot.getValue(Character.class);

                generalList = CharacterActivity.currCharacter.getListByName(CharacterActivity.mSelectedOption);

                adapter = new RecyclerViewAdapter(ListActivity.this, generalList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                DAddFragment alertDialog = DAddFragment.newInstance(CharacterActivity.mSelectedOption);
                alertDialog.show(fm, "fragment_alert");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseReference.removeEventListener(listDatabaseReferenceListener);
    }

}
