package com.shay.albinodnd;

import java.util.ArrayList;

public class Skill extends GeneralListItem {

    //fields
    private String name, description;
    private int level;

    //empty constructor for firebase
    public Skill() {

    }

    public Skill(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    //GeneralListItem functions
    public String getViewName() { return name; }
    public String getViewDescription() { return description + " in level " + level; }
    public String getItemType() { return Consts.SKILLS; }
    public ArrayList<String> getValuesToEdit() {
        ArrayList<String> valuesToEdit = new ArrayList<String>();
        valuesToEdit.add(Consts.SKILLDESCRIPTION);
        valuesToEdit.add(Consts.SKILLLEVEL);
        return valuesToEdit;
    }
    public ArrayList<String> getTypesOfValuesToEdit() {
        ArrayList<String> typesOfValuesToEdit = new ArrayList<String>();
        typesOfValuesToEdit.add(Consts.STRING);
        typesOfValuesToEdit.add(Consts.INTEGER);
        return typesOfValuesToEdit;
    }
}
