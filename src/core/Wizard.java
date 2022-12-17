package core;

public class Wizard extends Champion {

    private String spell;

    private boolean nacromancer;
    private String championType;


    public Wizard(String name,  int skillLevel, int entryFee, String spell, boolean nacromancer) {
        super(name, skillLevel, entryFee);
        this.spell = spell;
        this.nacromancer = nacromancer;
        championType = "Wizard";
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "spell='" + spell + '\'' +
                ", nacromancer=" + nacromancer +
                ", championType='" + championType + '\'' +
                ", name='" + name + '\'' +
                ", skillLevel=" + skillLevel +
                ", entryFee=" + entryFee +
                '}';
    }
}
