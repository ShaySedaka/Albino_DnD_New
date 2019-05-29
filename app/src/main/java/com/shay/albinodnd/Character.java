package com.shay.albinodnd;

import java.util.ArrayList;

public class Character {

    // character fields
    private String name, owner, favWeapon, charClass;
    private int level, currentXP, armorClass, maxHP, currHP,will,fortitude,reflex;
    private ArrayList<Attribute> attributes;
    private ArrayList<Item> inventory;
    private ArrayList<Skill> skills;

    public Character(){

    }

    public Character(String name, String owner, String charClass, String favWeapon, int level, int currentXP,
                     int armorClass,int will, int fortitude, int reflex, int maxHP, int currHP, ArrayList<Attribute> attributes,
                     ArrayList<Item> inventory, ArrayList<Skill> skills) {
        this.name = name;
        this.owner = owner;
        this.charClass = charClass;
        this.favWeapon = favWeapon;
        this.level = level;
        this.currentXP = currentXP;
        this.armorClass = armorClass;
        this.maxHP = maxHP;
        this.currHP = currHP;
        this.attributes = attributes;
        this.inventory = inventory;
        this.skills = skills;
        this.fortitude = fortitude;
        this.will = will;
        this.reflex = reflex;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getCharClass() { return charClass; }

    public String getFavWeapon() {
        return favWeapon;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public int getCurrHP() {
        return currHP;
    }

    public ArrayList<GeneralListItem> getListByName(String name) {
        ArrayList<GeneralListItem> list = new ArrayList<>();
        switch(name) {
            case "attributes":
                attributes.stream().forEach(list :: add);
                return list;
            case "inventory":
                inventory.stream().forEach(list :: add);
                return list;
            case "skills":
                skills.stream().forEach(list :: add);
                return list;
            default:
                return null;
        }
    }

    public int getWill() {
        return will;
    }

    public int getFortitude() {
        return fortitude;
    }

    public int getReflex() {
        return reflex;
    }
}
