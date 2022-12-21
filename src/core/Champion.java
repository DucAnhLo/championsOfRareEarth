package core;

import java.awt.*;

public abstract class Champion {
    String name;
    int skillLevel;
    int entryFee;
    //String stateString;
    ChampionState state;


    public Champion(String name,int skillLevel, int entryFee) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.entryFee = entryFee;
        //stateString = state.toString();
    }

    public String getName() {
        return name;
    }

    public int getEntryFee() {
        return entryFee;
    }


    public abstract String getChampionType();


    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", skillLevel=" + skillLevel +
                ", entryFee=" + entryFee +
                '}';
    }
}
