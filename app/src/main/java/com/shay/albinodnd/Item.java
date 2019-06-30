package com.shay.albinodnd;

import java.util.ArrayList;
import java.util.HashMap;

public class Item extends GeneralListItem {

    enum itemType
    {
        WEAPON, ARMOR, ACCESSORY, CONSUMABLE
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
    public String getItemType() { return Consts.INVENTORY; }
    public ArrayList<String> getValuesToEdit() {
        ArrayList<String> valuesToEdit = new ArrayList<String>();
        return valuesToEdit;
    }
    public ArrayList<String> getTypesOfValuesToEdit() {
        ArrayList<String> typesOfValuesToEdit = new ArrayList<String>();
        return typesOfValuesToEdit;
    }
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(Consts.ITEMNAME, getName());
        map.put(Consts.ITEMTYPE, getType().toString());
        return map;
    }

}
