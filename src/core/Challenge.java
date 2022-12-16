package core;

public class Challenge {
    int challengeNumber;
    String enemyName;
    int skillRequired;
    int reward;
    //ChallengeType type;
    String typeString;


    public Challenge(int challengeNumber,ChallengeType type,String enemyName, int skillRequired, int reward) {
        this.challengeNumber = challengeNumber;
        this.typeString = type.toString();
        this.enemyName = enemyName;
        this.skillRequired = skillRequired;
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "challengeNumber=" + challengeNumber +
                ", enemyName='" + enemyName + '\'' +
                ", skillRequired=" + skillRequired +
                ", reward=" + reward +
                ", type='" + typeString + '\'' +
                '}';
    }
}
