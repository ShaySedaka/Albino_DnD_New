package com.shay.albinodnd;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CharacterActivity extends AppCompatActivity {

    //Fields
    public static String mSelectedOption = "";
    private DatabaseReference databaseReference;
    private ValueEventListener characterDatabaseReferenceListener;
    public static Character currCharacter;

    private String getSelecterOption() {
        return mSelectedOption;
    }


    //Views
    Button btnAttributes, btnEquipment, btnInventory, btnSkills, btnSpells, btnLanguages, btnNotes;
    ImageView ivPortrait;
    TextView tvClass, tvCharName, tvHP, tvXP, tvAC, tvReflex, tvWill, tvFortitude,
            tvAtt1, tvAtt2, tvAtt3,tvAtt1_name, tvAtt2_name, tvAtt3_name, tvWeapon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        characterDatabaseReferenceListener = databaseReference.child(Consts.CHARACTERS).
                child(MainActivity.mSelectedCharacter).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currCharacter = dataSnapshot.getValue(Character.class);
                Log.d("Albino D&D", "Selected character is: " + MainActivity.mSelectedCharacter);
                Log.d("Albino D&D", printAttributes());
                sortAttributes();
                loadCharacterData();
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
        databaseReference.removeEventListener(characterDatabaseReferenceListener);
    }

    private void getViews() {
        btnAttributes = findViewById(R.id.button_character_attributes);
        btnEquipment = findViewById(R.id.button_character_equipment);
        btnInventory = findViewById(R.id.button_character_inventory);
        btnSkills = findViewById(R.id.button_character_skills);
        btnSpells = findViewById(R.id.button_character_spells);
        btnLanguages = findViewById(R.id.button_character_languages);
        btnNotes = findViewById(R.id.button_character_notes);

        ivPortrait = findViewById(R.id.character_portrait);

        tvCharName = findViewById(R.id.character_name);
        tvClass = findViewById(R.id.character_class);
        tvAC = findViewById(R.id.character_armorclass);
        tvXP = findViewById(R.id.character_xp);
        tvHP = findViewById(R.id.character_hp);
        tvWill = findViewById(R.id.character_will);
        tvFortitude = findViewById(R.id.character_fortitude);
        tvReflex = findViewById(R.id.character_reflex);
        tvAtt1 = findViewById(R.id.character_topatt1);
        tvAtt2 = findViewById(R.id.character_topatt2);
        tvAtt3 = findViewById(R.id.character_topatt3);
        tvAtt1_name = findViewById(R.id.character_topatt1_name);
        tvAtt2_name = findViewById(R.id.character_topatt2_name);
        tvAtt3_name = findViewById(R.id.character_topatt3_name);
        tvWeapon = findViewById(R.id.character_equipped_weapon);


    }

    private void setListeners() {
        btnInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CharacterActivity.this, ListActivity.class);
                mSelectedOption = Consts.INVENTORY;
                CharacterActivity.this.startActivity(myIntent);
            }
        });

        btnSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CharacterActivity.this, ListActivity.class);
                mSelectedOption = Consts.SKILLS;
                CharacterActivity.this.startActivity(myIntent);
            }
        });

        btnAttributes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CharacterActivity.this, ListActivity.class);
                mSelectedOption = Consts.ATTRIBUTES;
                CharacterActivity.this.startActivity(myIntent);
            }
        });
    }


//    private Character extractSelectedCharacter() {
//        Character result = null;
//        for (int i = 0; i < characters.size(); i++) {
//            if (MainActivity.mSelectedCharacter.compareTo(characters.get(i).getName()) == 0) {
//                result = characters.get(i);
//                Log.d("Albino D&D", "Selected character is: " + MainActivity.mSelectedCharacter);
//            }
//        }
//        currCharacter = result;
//        Log.d("Albino D&D", printAttributes());
//        sortAttributes();
//        return result;
//    }

    private String printAttributes(){
        String result = "   \n";
        for(int i = 0; i < currCharacter.getAttributes().size(); i++){
            result = result  + currCharacter.getAttributes().get(i).getAttName() + "  " + currCharacter.getAttributes().get(i).getAttValue() + "\n";
        }
        return result;
    }

    private void loadCharacterPortrait() {
        int portrait_id = -1;

        switch(this.currCharacter.getName()){

            case Consts.LUCIAN:
                portrait_id = R.drawable.thief_large;
                break;
            case Consts.RIG:
                portrait_id = R.drawable.fighter_large;
                break;
            case Consts.INIGO:
                portrait_id = R.drawable.paladin_large;
                break;
            case Consts.FEMINA:
                portrait_id = R.drawable.barbarian_large;
                break;
            case Consts.MERLIN:
                portrait_id = R.drawable.mage_large;
                break;
            case Consts.HIRETSON:
                portrait_id = R.drawable.bard_large;
                break;
            case Consts.BREANNE:
                portrait_id = R.drawable.druid_large;
                break;
            case Consts.CUAHU:
                portrait_id = R.drawable.ranger_large;
                break;
        }

        ivPortrait.setImageResource(portrait_id);
    }


    private ArrayList<Attribute> sortAttributes()
    {
        ArrayList<Attribute> sorted = currCharacter.getAttributes();

        int n = sorted.size();
        Attribute temp = sorted.get(0);
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(sorted.get(j-1).getAttValue() < sorted.get(j).getAttValue()){
                    //swap elements
                    temp = sorted.get(j-1);
                    sorted.set(j-1, sorted.get(j));
                    sorted.set(j,temp);
                }
            }
        }

        for (int i = 0; i < sorted.size(); i++) {
            Log.d("Albino D&D","sorted " + (i+1) + " " +sorted.get(i).getAttName() +" "+sorted.get(i).getAttValue() + " \n");
        }

        return sorted;
    }

    private ArrayList<Attribute> getTopThreeAttributes(){

        ArrayList<Attribute> top3 = new ArrayList<Attribute>();

        top3.add(sortAttributes().get(0));
        top3.add(sortAttributes().get(1));
        top3.add(sortAttributes().get(2));

        return top3;
    }

    private void loadCharacterTextViews(ArrayList<Attribute> top3){

        tvCharName.setText(currCharacter.getName());
        tvClass.setText(String.valueOf(currCharacter.getCharClass()));
        tvHP.setText(currCharacter.getCurrHP()+"/"+currCharacter.getMaxHP());
        tvXP.setText(String.valueOf(currCharacter.getCurrentXP()));
        tvAC.setText(String.valueOf(currCharacter.getArmorClass()));
        tvReflex.setText(String.valueOf(currCharacter.getReflex()));
        tvWill.setText(String.valueOf(currCharacter.getWill()));
        tvFortitude.setText(String.valueOf(currCharacter.getFortitude()));
        tvWeapon.setText(String.valueOf(currCharacter.getFavWeapon()));

        tvAtt1.setText(String.valueOf(top3.get(0).getAttValue()));
        tvAtt2.setText(String.valueOf(top3.get(1).getAttValue()));
        tvAtt3.setText(String.valueOf(top3.get(2).getAttValue()));
        
        tvAtt1_name.setText(top3.get(0).getAttName());
        tvAtt2_name.setText(top3.get(1).getAttName());
        tvAtt3_name.setText(top3.get(2).getAttName());


    }
    private void loadCharacterData()
    {
        loadCharacterPortrait();
        ArrayList<Attribute> top3 = getTopThreeAttributes();
        loadCharacterTextViews(top3);
    }


}
