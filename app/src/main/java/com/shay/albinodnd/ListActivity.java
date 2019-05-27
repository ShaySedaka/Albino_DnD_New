package com.shay.albinodnd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<GeneralListItem> GeneralList = new ArrayList<>();
    private Character selectedCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));

        selectedCharacter = CharacterActivity.characters.stream()
                .filter(character -> MainActivity.mSelectedCharacter.equals(character.getName()))
                .findAny()
                .orElse(null);

        GeneralList = selectedCharacter.getListByName(CharacterActivity.mSelectedOption);

        adapter = new RecyclerViewAdapter(ListActivity.this, GeneralList);
        recyclerView.setAdapter(adapter);

    }


}