package com.shay.albinodnd;

public class Attribute {

    //fields
    private String attName;
    private int attValue;

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
}
