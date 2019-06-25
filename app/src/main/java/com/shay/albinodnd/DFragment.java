package com.shay.albinodnd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class DFragment extends DialogFragment {

    public DFragment() {
        // Empty constructor required for DialogFragment
    }

    public static DFragment newInstance(GeneralListItem listItem, int itemID) {
        DFragment frag = new DFragment();
        frag.setArguments(createArgsForDFragment(listItem, itemID));
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        String itemType = getArguments().getString("itemType");
        String itemName = getArguments().getString("itemName");
        String itemViewName = getArguments().getString("itemViewName");
        ArrayList<String> valuesToEdit = getArguments().getStringArrayList("valuesToEdit");
        ArrayList<String> typesOfValuesToEdit = getArguments().getStringArrayList("typesOfValuesToEdit");
        int itemID = getArguments().getInt("itemID");

        View v = inflater.inflate(R.layout.dialog_edit, null);
        TextView titleTextView = (TextView) v.findViewById(R.id.title);
        titleTextView.setText(itemViewName);

        ArrayList<EditText> values = setEditTextsInView(v, valuesToEdit);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(v)
                // Add action buttons
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // edit item
                        //String value = value1.getText().toString();

                        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                                .getReference().child(Consts.CHARACTERS)
                                .child(MainActivity.mSelectedCharacter).child(itemType)
                                .child(Integer.toString(itemID));

                        for (int i = 0 ; i < valuesToEdit.size() ; i++) {
                            String value = values.get(i).getText().toString();
                            if ("" != value) {
                                if (Consts.INTEGER == typesOfValuesToEdit.get(i)) {
                                    databaseReference.child(valuesToEdit.get(i)).setValue(Integer.valueOf(value));
                                } else if (Consts.STRING == typesOfValuesToEdit.get(i)) {
                                    databaseReference.child(valuesToEdit.get(i)).setValue(value);
                                }
                            }
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public static Bundle createArgsForDFragment(GeneralListItem listItem, int itemID) {
        Bundle args = new Bundle();
        args.putString("itemType", listItem.getItemType());
        args.putString("itemName", listItem.getName());
        args.putString("itemViewName", listItem.getViewName());
        args.putStringArrayList("valuesToEdit",listItem.getValuesToEdit());
        args.putStringArrayList("typesOfValuesToEdit",listItem.getTypesOfValuesToEdit());
        args.putInt("itemID", itemID);

        return args;
    }

    public ArrayList<EditText> setEditTextsInView(View v, ArrayList<String> valuesToEdit) {
        ArrayList<EditText> values = new  ArrayList<EditText>();
        switch (valuesToEdit.size()) {
            case 3:
                final EditText value3 = (EditText) v.findViewById(R.id.value3);
                value3.setHint(valuesToEdit.get(2));
                value3.setVisibility(View.VISIBLE);
                values.add(2,value3);
            case 2:
                final EditText value2 = (EditText) v.findViewById(R.id.value2);
                value2.setHint(valuesToEdit.get(1));
                value2.setVisibility(View.VISIBLE);
                values.add(1,value2);
            default:
                final EditText value1 = (EditText) v.findViewById(R.id.value1);
                value1.setHint(valuesToEdit.get(0));
                values.add(0,value1);
        }
        return values;
    }
}
