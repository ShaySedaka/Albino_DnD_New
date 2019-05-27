package com.shay.albinodnd;

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
}
