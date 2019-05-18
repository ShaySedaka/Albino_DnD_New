import java.util.ArrayList;

public class Character {

    // character fields
    private String name, owner, favWeapon;
    private int level, currentXP, armorClass, maxHP, currHP;
    private ArrayList<Attribute> attributes;
    private ArrayList<Item> inventory;
    private ArrayList<Skill> skills;

    public Character(String name, String owner, String favWeapon, int level, int currentXP,
                     int armorClass, int maxHP, int currHP, ArrayList<Attribute> attributes,
                     ArrayList<Item> inventory, ArrayList<Skill> skills) {
        this.name = name;
        this.owner = owner;
        this.favWeapon = favWeapon;
        this.level = level;
        this.currentXP = currentXP;
        this.armorClass = armorClass;
        this.maxHP = maxHP;
        this.currHP = currHP;
        this.attributes = attributes;
        this.inventory = inventory;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

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
}
