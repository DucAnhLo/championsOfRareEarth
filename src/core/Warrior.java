package core;

public class Warrior extends Champion {

    private String weapon;
    private String championType;


    public Warrior(String name, int skillLevel, int entryFee, String weapon) {
        super(name, skillLevel, entryFee);
        this.weapon = weapon;
        championType = "Warrior";
    }

    @Override
    public String getChampionType() {
        return championType;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "weapon='" + weapon + '\'' +
                ", championType='" + championType + '\'' +
                ", name='" + name + '\'' +
                ", skillLevel=" + skillLevel +
                ", entryFee=" + entryFee +
                '}';
    }
}
