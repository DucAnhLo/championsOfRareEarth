package core;

public class Dragon extends Champion{

     private boolean talkAbility;
     private String championType;

    public Dragon(String name, int skillLevel, int entryFee, boolean talkAbility) {
        super(name, skillLevel, entryFee);
        this.talkAbility = talkAbility;
        championType = "Dragon";
    }

    public boolean isTalkAbility() {
        return talkAbility;
    }

    @Override
    public String getChampionType() {
        return championType;
    }



    @Override
    public String toString() {
        return "Dragon{" +
                "talkAbility=" + talkAbility +
                ", championType='" + championType + '\'' +
                ", name='" + name + '\'' +
                ", skillLevel=" + skillLevel +
                ", entryFee=" + entryFee +
                '}';
    }
}
