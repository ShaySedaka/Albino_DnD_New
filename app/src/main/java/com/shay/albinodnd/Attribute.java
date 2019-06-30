package com.shay.albinodnd;

import java.util.ArrayList;
import java.util.HashMap;

public class Attribute extends GeneralListItem {

    //fields
    private String attName;
    private int attValue;

    //empty constructor for firebase
    public Attribute(){

    }

    public Attribute(String attName, int attValue) {
        this.attName = attName;
        this.attValue = attValue;
    }

    public String getAttName() {
        return attName;
    }

    public int getAttValue() {
        return attValue;
    }

    //GeneralListItem functions
    public String getViewName() { return attName; }
    public String getViewDescription() { return "attribute value is " + attValue; }
    public String getName() {
        return attName;
    }
    public String getItemType() { return Consts.ATTRIBUTES; }
    public ArrayList<String> getValuesToEdit() {
        ArrayList<String> valuesToEdit = new ArrayList<String>();
        valuesToEdit.add(Consts.ATTVALUE);
        return valuesToEdit;
    }
    public ArrayList<String> getTypesOfValuesToEdit() {
        ArrayList<String> typesOfValuesToEdit = new ArrayList<String>();
        typesOfValuesToEdit.add(Consts.INTEGER);
        return typesOfValuesToEdit;
    }
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(Consts.ATTNAME, getAttName());
        map.put(Consts.ATTVALUE, getAttValue() );
        return map;
    }
}
