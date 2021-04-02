public class FootballTeam extends Team {
    String type;
    
    public FootballTeam(String teamName, String gender, int numberOfPlayers, String type) {
        super(teamName, gender, numberOfPlayers);
        this.type = type;
    }
}