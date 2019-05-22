package com.shay.albinodnd;

import android.media.Image;

public class Item {


    enum itemType
    {
        WEAPON, ARMOR, ACCESSORY, CONSUMABLE;
    }

    //fields
    private String name;
    private itemType type;

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

}
