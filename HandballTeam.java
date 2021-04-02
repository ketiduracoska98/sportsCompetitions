public class HandballTeam extends Team
{
	// Singleton desing patter
    String type;
    // it is private and can not be constructed new object
    private HandballTeam(String teamName, String gender, int numberOfPlayers, String type) {
        super(teamName, gender, numberOfPlayers);
        this.type = type;
    }
    // method for creating a new object/instance (Singleton desing patter)
    public static HandballTeam getInstance(String teamname, String gender, int numberOfPlayers, String type) {
        HandballTeam instance = new HandballTeam(teamname,gender,numberOfPlayers,type);
        return instance;
    }
}