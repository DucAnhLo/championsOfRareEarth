package core;
import java.util.*;

/**
 * This class implements the behaviour expected from the CORE
* as required for 6COM1037 Cwk Assignment - Nov 2022
 * 
 * @author 
 * @version 05/10/22
 */

public class Tournament extends Treasury implements CORE
{
    // Fields
    static ArrayList<Warrior> warriorList = new ArrayList<>();
    static ArrayList<Wizard> wizardList = new ArrayList<>();
    static ArrayList<Dragon> dragonList = new ArrayList<>();
    static ArrayList<Champion> championList = new ArrayList<>();
    static ArrayList<Challenge> challengeList = new ArrayList<>();
    static ArrayList<Champion> reserveList = new ArrayList<>();

    static ArrayList<Champion> playerTeam = new ArrayList<>();
    private static String playerName;
    private static Treasury treasury = new Treasury();



//    public static void main(String[] args) {
//        initilizeChampion();
//        Champion ch;
//        String nme = "Argon";
//        //ch.name = nme;
//        for (int i = 0; i < championList.size(); i++) {
//            if(championList.contains(ch)){
//                System.out.println(1);
//            }
//        }
//    }
   private String gameStatus(){
        String gameStatus;
        if(isDefeated()){
            gameStatus = "Defeated";
        }else {
            gameStatus = "Is OK";
        }
        return gameStatus;
   }

    private String teamStatus(){
        String teamStatus = null;
        if(playerTeam == null){
            teamStatus = "No Champions";
        }
        return teamStatus;
    }
    private static void setupChampion(){
        Wizard ganfrank = new Wizard("Ganfrank",7,400, "transmutation", true);
        wizardList.add(ganfrank);
        Wizard rudolf = new Wizard("Rudolf", 6,400, "invisibility", true);
        wizardList.add(rudolf);
        Warrior elblond = new Warrior("Elblond", 1,150,"sword");
        warriorList.add(elblond);
        Warrior flimsi = new Warrior("Flimsi", 2, 200, "bow");
        warriorList.add(flimsi);
        Dragon drabina = new Dragon("Drabina",7, 500, false);
        dragonList.add(drabina);
        Dragon golum = new Dragon("Golum",7, 500, true);
        dragonList.add(golum);
        Warrior argon = new Warrior("Argon", 9,900,"mace");
        warriorList.add(argon);
        Wizard neon = new Wizard("Neon", 2,300, "translocation", false);
        wizardList.add(neon);
        Dragon xenon = new Dragon("Xenon", 7, 500, true);
        dragonList.add(xenon);
        Warrior atlanta = new Warrior("Atlanta", 5, 500, "bow");
        warriorList.add(atlanta);
        Wizard krypton = new Wizard("Krypton", 8, 300,"fireballs", false);
        wizardList.add(krypton);
        Wizard hedwig = new Wizard("Hedwig", 1,400,"flying", true);
        wizardList.add(hedwig);
    }

    private static void setupChallenges(){
        Challenge challenge1 = new Challenge(1, ChallengeType.MAGIC, "Borg", 3, 100);
        challengeList.add(challenge1);
        Challenge challenge2 = new Challenge(2, ChallengeType.FIGHT, "Huns", 3, 120);
        challengeList.add(challenge2);
        Challenge challenge3 = new Challenge(3, ChallengeType.MYSTERY, "Ferengi", 3, 150);
        challengeList.add(challenge3);
        Challenge challenge4 = new Challenge(4, ChallengeType.MAGIC, "Vandal", 9, 200);
        challengeList.add(challenge4);
        Challenge challenge5 = new Challenge(5, ChallengeType.MYSTERY, "Borg", 7, 90);
        challengeList.add(challenge5);
        Challenge challenge6 = new Challenge(6, ChallengeType.FIGHT, "Goth", 8, 45);
        challengeList.add(challenge6);
        Challenge challenge7 = new Challenge(7, ChallengeType.MAGIC, "Frank", 10, 200);
        challengeList.add(challenge7);
        Challenge challenge8 = new Challenge(8, ChallengeType.FIGHT, "Sith", 10, 170);
        challengeList.add(challenge8);
        Challenge challenge9 = new Challenge(9, ChallengeType.MYSTERY, "Cardashian", 9, 300);
        challengeList.add(challenge9);
        Challenge challenge10 = new Challenge(10, ChallengeType.FIGHT, "Jude", 2, 300);
        challengeList.add(challenge10);
        Challenge challenge11 = new Challenge(11, ChallengeType.MAGIC, "Celt", 2, 250);
        challengeList.add(challenge11);
        Challenge challenge12 = new Challenge(12, ChallengeType.MYSTERY, "Celt", 1, 250);
        challengeList.add(challenge12);
    }

    private static void initilizeChampion(){
       setupChampion();
       for(Warrior wr : warriorList){
           championList.add(wr);
       }
        for(Wizard wz : wizardList){
            championList.add(wz);
        }
        for(Dragon dr : dragonList){
            championList.add(dr);
        }
    }

    private static void initilizeReverse(){
       initilizeChampion();
       for(Champion ch: championList){
           reserveList.add(ch);
       }
    }
    //**************** CORE **************************
    /** Constructor requires the name of the player
     * @param pl the name of the player
     */
    public Tournament(String pl)
    {
       playerName = pl;
    }


    //******* Implements interface CORE *******************
    /**Returns a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the
     * team,(or, "No champions" if team is empty)
     *
     * @return a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the
     * team,(or, "No champions" if team is empty)
     */
//


    @Override
    public String toString() {
        String inGameStatus = gameStatus();
        String inGameTeamStatus = gameStatus();
        String returnedString = playerName + treasury + inGameStatus + inGameTeamStatus;
        return returnedString;
    }

    /** returns true if Treasury <=0 and the player's team has no
     * champions which can be withdrawn.
     * @return true if Treasury <=0 and the player's team has no
     * champions which can be decommissioned.
     */
    public boolean isDefeated(){
        if(treasury.balance <= 0 && playerTeam == null){
            return true;
        }else{
            return false;
        }
    }

    /** returns the amount of money in the Treasury
     * @return the amount of money in the Treasury
     */
    public int getMoney(){
       return treasury.balance;
    }

    /**Returns a String representation of all champions in reserve
     * @return a String representation of all champions in reserve
     **/
    public String getReserve(){
        initilizeChampion();
        for(Champion ch :championList){
            if(!playerTeam.contains(ch)){
                ch.state = ChampionState.WAITING;
                reserveList.add(ch);
            }
        }
       return "" + reserveList;
    }

    /** Returns details of any champion with the given name
     * @param nme is the name of the champion
     * @return details of any champion with the given name
     **/
    public String getChampionDetails(String nme){
        setupChampion();
        String result = null;
        for(int i =0; i<warriorList.size();i++){
            Warrior wr = warriorList.get(i);
            if(nme == wr.name){
                result = String.valueOf(wr);
            }
        }
       return result;
    }

    /** returns whether champion is in reserve
    * @param nme is the name of the champion
    * @return true if champion in reserve, false otherwise
    */
    public boolean isInReserve(String nme) {
        for(Champion ch: reserveList){
            if(ch.name == nme){
                return true;
            }
        }
        return false;
    }

 // ***************** Players Team************************
    /** Allows a champion to be entered for the player's team, if there
     * is enough money in the Treasury for the entry fee.The champion's
     * state is set to "active"
     * 0 if champion is entered in the player's team,
     * 1 if champion is not in reserve,
     * 2 if not enough money in the treasury,
     * -1 if there is no such champion
     * @param nme represents the name of the champion
     * @return as shown above
     **/
    public int enterChampion(String nme){
        getReserve();
        for(int i = 0; i<reserveList.size();i++) {
            Champion ch = reserveList.get(i);
            if (!String.valueOf(championList).contains(nme)) {
                return -1;
            } else if (treasury.balance >= ch.entryFee) {
                playerTeam.add(ch);
                reserveList.remove(ch);
                //treasury.balance = treasury.balance ;
                return 0;
            } else if (String.valueOf(playerTeam).contains(nme)) {
                return 1;
            } else if (treasury.balance < ch.entryFee) {
                return 2;
            }
        }
        return 0;
    }


    /** Returns true if the champion with the name is in
     * the player's team, false otherwise.
     * @param nme is the name of the champion
     * @return  true if the champion with the name
     * is in the player's team, false otherwise.
     **/
    public boolean isInPlayersTeam(String nme){
        if(playerTeam.contains(nme)){
            return true;
        }
       return false;
    }

    /** Removes a champion from the team to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is retired to reserves
     * 1 - if champion not retired because dead
     * 2 - if champion not retired because not in team
     * -1 - if no such champion
     * @param nme is the name of the champion
     * @return as shown above
     **/
    public int retireChampion(String nme){
        for(int i = 0; i < playerTeam.size();i++){
            if(!String.valueOf(championList).contains(nme)){
                return -1;
            }
            else if(!String.valueOf(playerTeam).contains(nme)){
                return 2;
            }
            else if(String.valueOf(playerTeam).contains(nme)){
                playerTeam.remove(nme);
                return 0;
            }
            else if(ch.state == ChampionState.DEAD){
                return 1;
            }
        }
       return -3;
    }


    /**Returns a String representation of the champions in the player's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the player's team
     **/
    public String getTeam(){

       return "";
    }


//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the number of the challenge
     * @return true if the number represents a challenge
     **/
     public boolean isChallenge(int num) {
         setupChallenges();
         for(int i = 0; i<challengeList.size();i ++){
             Challenge challenge = challengeList.get(i);
             int challengeNum = challenge.challengeNumber;
             if(challengeNum == num){
                 return true;
             }
         }
         return false;
     }

    /** Provides a String representation of an challenge given by
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by
     * the challenge number
     **/
    public String getChallenge(int num){
        setupChallenges();
        String type = null;
        for(int i = 0; i< challengeList.size(); i++){
            Challenge ch = challengeList.get(i);
            if(ch.challengeNumber == num){
                type = ch.typeString;
            }
        }
       return " " + type;
    }

    /** Provides a String representation of all challenges
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges() {
        setupChallenges();
        ArrayList<String> challengeDetail = new ArrayList<>();
        for (int i = 0; i < challengeList.size(); i++) {
            Challenge ch = challengeList.get(i);
            challengeDetail.add(String.valueOf(ch));
        }
        String result = String.join(", ", challengeDetail);
        return result;
    }

    /** Retrieves the challenge represented by the challenge
     * number.Finds a champion from the team which can challenge the
     * challenge. The results of fighting an challenge will be
     * one of the following:
     * 0 - challenge won, add reward to the treasury,
     * 1 - challenge lost on battle skills  - deduct reward from
     * treasury and record champion as "dead"
     * 2 - challenge lost as no suitable champion is  available, deduct
     * the reward from treasury
     * 3 - If a challenge is lost and player completely defeated (no money and
     * no champions to withdraw)
     * -1 - no such challenge
     * @param chalNo is the number of the challenge
     * @return an int showing the result(as above) of fighting the challenge
     */
    public int fightChallenge(int chalNo){

       return 0;
    }

//// These methods are not needed until Task 4.4
//    // ***************   file write/read  *********************
//    /** Writes whole game to the specified file
//     * @param fname name of file storing requests
//     */
//    public void saveGame(String fname){
//
//
//    }
//
//    /** reads all information about the game from the specified file
//     * and returns a CORE reference to a Tournament object
//     * @param fname name of file storing the game
//     * @return the game (as a Tournament object)
//     */
//    public CORE loadGame(String fname){
//
//       return null;
//    }
//
//    /**
//     * reads challenges from a comma-separated textfile and stores
//     * @param filename of the comma-separated textfile storing information about challenges
//     */
//    public void readChallenges(String filename){
//
//    }
}



