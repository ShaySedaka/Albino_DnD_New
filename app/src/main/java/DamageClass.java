public class DamageClass {

    public enum DieType {
        D2, D4, D6, D8, D10, D12, D20;
    }


    //fields
    private int numRolls;
    private DieType die;

    public DamageClass(int numRolls, DieType die) {
        this.numRolls = numRolls;
        this.die = die;
    }

    public int getNumRolls() {
        return numRolls;
    }


    public DieType getDie() {
        return die;
    }

}
