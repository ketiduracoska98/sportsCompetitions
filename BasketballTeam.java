public class BasketballTeam extends Team {
    String type;

    public BasketballTeam(String teamName, String gender, int numberOfPlayers, String type) {
        super(teamName, gender, numberOfPlayers);
        this.type = type;
    }
}