package core;

public class Dragon extends Champion{

     private boolean talkAbility;
     private String championType;

    public Dragon(String name, int skillLevel, int entryFee, boolean talkAbility) {
        super(name, skillLevel, entryFee);
        this.talkAbility = talkAbility;
        championType = "Dragon";
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "talkAbility=" + talkAbility +
                ", championType='" + championType + '\'' +
                '}';
    }
}
