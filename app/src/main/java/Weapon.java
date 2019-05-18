public class Weapon extends Item {

    enum WeaponType{

        SHORT_SWORD, LONG_SWORD, BOW, DAGGER, THROWING_KNIFE, STAFF, MACE, CROSSBOW, WAND, ONE_HANDED_AXE, TWO_HANDED_AXE;
    }

    //fields
    String nickName;
    WeaponType wType;
    DamageClass dmgClass;


    public Weapon(String name, String nickName, WeaponType wType, DamageClass dmgClass) {
        super(name, itemType.WEAPON);
        this.wType = wType;
        this.nickName = nickName;
        this.dmgClass = dmgClass;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public DamageClass getDmgClass() {
        return dmgClass;
    }

    public WeaponType getwType() {
        return wType;
    }
}
