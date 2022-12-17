package core;

import java.awt.*;

public class Champion {
    String name;
    int skillLevel;
    int entryFee;
    String stateString;



    public Champion(String name, ChampionState state, int skillLevel, int entryFee) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.entryFee = entryFee;
        stateString = state.toString();
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
