package core;

public class Warrior extends Champion {

    private String weapon;
    private String championType;


    public Warrior(String name, ChampionState state, int skillLevel, int entryFee) {
        super(name, state, skillLevel, entryFee);
        this.weapon = weapon;
        championType = "Warrior";
    }
}
