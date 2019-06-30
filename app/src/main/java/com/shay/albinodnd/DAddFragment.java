package com.shay.albinodnd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class DAddFragment extends DialogFragment {

    public DAddFragment() {
        // Empty constructor required for DialogFragment
    }

    public static DAddFragment newInstance(String option) {
        DAddFragment frag = new DAddFragment();
        frag.setArguments(createArgsForDFragment(option));
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        String itemViewName = getArguments().getString("itemViewName");
        ArrayList<String> valuesToEdit = getArguments().getStringArrayList("valuesToEdit");
        ArrayList<String> typesOfValuesToEdit = getArguments().getStringArrayList("typesOfValuesToEdit");
        String option = getArguments().getString("option");
        int size = getArguments().getInt("size");

        View v = inflater.inflate(R.layout.dialog_add, null);

        final EditText viewName = (EditText) v.findViewById(R.id.title);
        viewName.setHint(itemViewName);

        ArrayList<EditText> values = setEditTextsInView(v, valuesToEdit, typesOfValuesToEdit);

        Spinner sp = setSpinnerInView(v, option);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(v)
                // Add action buttons
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                                .getReference().child(Consts.CHARACTERS)
                                .child(MainActivity.mSelectedCharacter).child(option);

                        ArrayList<HashMap<String, Object>> newValue = new ArrayList<HashMap<String, Object>>();

                        // add item
                        switch (option) {
                            case Consts.ATTRIBUTES:
                                ArrayList<Attribute> attributes = CharacterActivity.currCharacter.getAttributes();
                                attributes.add(new Attribute(viewName.getText().toString(), Integer.valueOf(values.get(0).getText().toString())));
                                for (Attribute att : attributes) {
                                    newValue.add(att.toMap());
                                }
                                break;
                            case Consts.INVENTORY:
                                String value = sp.getSelectedItem().toString();
                                Item.itemType it = null;
                                for (int i = 0; i < Consts.ITEMTYPESENUM.length; i++) {
                                    if (Consts.ITEMTYPESENUM[i].equals(value)) {
                                        it = Item.itemType.values()[i];
                                    }
                                }

                                ArrayList<Item> items = CharacterActivity.currCharacter.getInventory();
                                items.add(new Item(viewName.getText().toString(), it));
                                for (Item item : items) {
                                    newValue.add(item.toMap());
                                }
                                break;
                            case Consts.SKILLS:
                                ArrayList<Skill> skills = CharacterActivity.currCharacter.getSkills();
                                skills.add(new Skill(viewName.getText().toString(), values.get(0).getText().toString(),
                                        Integer.valueOf(values.get(1).getText().toString())));
                                for (Skill s : skills) {
                                    newValue.add(s.toMap());
                                }

                                break;
                            default:

                        }
                        databaseReference.setValue(newValue);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DAddFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public static Bundle createArgsForDFragment(String option) {
        Bundle args = new Bundle();
        ArrayList<String> valuesToEdit = new ArrayList<String>();
        ArrayList<String> typesOfValuesToEdit = new ArrayList<String>();
        String itemViewName = null;

        switch (option) {
            case Consts.ATTRIBUTES:
                Attribute a = new Attribute();
                itemViewName = Consts.ATTNAME;
                valuesToEdit = a.getValuesToEdit();
                typesOfValuesToEdit = a.getTypesOfValuesToEdit();
                break;
            case Consts.INVENTORY:
                Item i = new Item();
                itemViewName = i.getViewName();
                valuesToEdit = i.getValuesToEdit();
                typesOfValuesToEdit = i.getTypesOfValuesToEdit();
                break;
            case Consts.SKILLS:
                Skill s = new Skill();
                itemViewName = s.getViewName();
                valuesToEdit = s.getValuesToEdit();
                typesOfValuesToEdit = s.getTypesOfValuesToEdit();
                break;
            default:

        }

        args.putString("itemViewName", itemViewName);
        args.putStringArrayList("valuesToEdit",valuesToEdit);
        args.putStringArrayList("typesOfValuesToEdit",typesOfValuesToEdit);
        args.putString("option", option);

        return args;
    }

    public ArrayList<EditText> setEditTextsInView(View v, ArrayList<String> valuesToEdit, ArrayList<String> typesOfValuesToEdit) {
        ArrayList<EditText> values = new  ArrayList<EditText>();
        switch (valuesToEdit.size()) {
            case 3:
                final EditText value3 = (EditText) v.findViewById(R.id.value3);
                value3.setHint(valuesToEdit.get(2));
                value3.setVisibility(View.VISIBLE);
                if (Consts.INTEGER.equals(typesOfValuesToEdit.get(2))) {
                    value3.setInputType(InputType.TYPE_CLASS_NUMBER);
                } else if (Consts.STRING.equals(typesOfValuesToEdit.get(2))) {
                    value3.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                values.add(2,value3);
            case 2:
                final EditText value2 = (EditText) v.findViewById(R.id.value2);
                value2.setHint(valuesToEdit.get(1));
                value2.setVisibility(View.VISIBLE);
                if (Consts.INTEGER.equals(typesOfValuesToEdit.get(1))) {
                    value2.setInputType(InputType.TYPE_CLASS_NUMBER);
                } else if (Consts.STRING.equals(typesOfValuesToEdit.get(1))) {
                    value2.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                values.add(1,value2);
            case 1:
                final EditText value1 = (EditText) v.findViewById(R.id.value1);
                value1.setHint(valuesToEdit.get(0));
                value1.setVisibility(View.VISIBLE);
                if (Consts.INTEGER.equals(typesOfValuesToEdit.get(0))) {
                    value1.setInputType(InputType.TYPE_CLASS_NUMBER);
                } else if (Consts.STRING.equals(typesOfValuesToEdit.get(0))) {
                    value1.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                values.add(0,value1);
            default:
        }
        return values;
    }

    public Spinner setSpinnerInView(View v, String option) {

        if(Consts.INVENTORY.equals(option)) {
            final ArrayAdapter<String> adp = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_spinner_item, Consts.ITEMTYPESENUM);

            final Spinner sp = v.findViewById(R.id.spn);
            sp.setAdapter(adp);
            sp.setVisibility(View.VISIBLE);
            return sp;
        }
        return null;
    }
}

