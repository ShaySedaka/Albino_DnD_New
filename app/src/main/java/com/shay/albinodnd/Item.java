package com.shay.albinodnd;

import android.media.Image;

public class Item extends GeneralListItem {

    enum itemType
    {
        WEAPON, ARMOR, ACCESSORY, CONSUMABLE;
    }

    //fields
    private String name;
    private itemType type;

    //empty constructor for firebase
    public Item() {

    }

    public Item(String name, itemType type) {
        this.name = name;
        this.type = type;
    }

    public itemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    //GeneralListItem functions
    public String getViewName() { return name; }
    public String getViewDescription() { return "from type " + type.toString().toLowerCase(); }

}
