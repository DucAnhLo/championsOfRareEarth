package core;

import java.awt.*;

public class Champion {
    private String name;
    private int skillLevel;
    private int entryFee;
    private ChampionState active = ChampionState.ACTIVE;
    private ChampionState waiting = ChampionState.WAITING;
    private ChampionState dead = ChampionState.DEAD;



    public Champion(String name, int skillLevel, int entryFee) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.entryFee = entryFee;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", skillLevel=" + skillLevel +
                ", entryFee=" + entryFee +
                '}';
    }
}
