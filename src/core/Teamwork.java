package core;


/**
 * Details of your team
 * 
 * @author Duc Anh Lo
 * @version 1.0
 */
public class Teamwork
{
    private String[] details = new String[7];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        details[0] = "Team 2";
        details[1] = "Lo";
        details[2] = "Duc Anh";
        details[3] = "19034566";
        details[4] = "Gospelhope Oquong";
        details[5] = "David";
        details[6] = "20002811";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
