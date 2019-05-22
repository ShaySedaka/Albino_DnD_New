package com.shay.albinodnd;

public class Armor extends Item {

    enum ArmorPiece{
        HEAD, CHEST, LEGS, BOOTS, GLOVES;
    }

    enum ArmorType{
        LIGHT, MEDIUM, HEAVY;
    }

    //fields
    private ArmorPiece aPiece;
    private ArmorType aType;

    public Armor(String name, ArmorPiece aPiece, ArmorType aType) {
        super(name,itemType.ARMOR);
        this.aPiece = aPiece;
        this.aType = aType;
    }

    public ArmorPiece getaPiece() {
        return aPiece;
    }

    public ArmorType getaType() {
        return aType;
    }
}
