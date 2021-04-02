public class Choosetype {
	// Factory desing pattern returns a new object based of a type
    /**
     * @param type type of a team
     * @param teamName name of a team
     * @param gender gender of team's players
     * @param numberOfPlayers number of players
     * @return new object
     */
    public Team team_type(String type, String teamName, String gender, int numberOfPlayers) {
        if(type.equals("basketball")) {
            return new BasketballTeam(teamName,gender,numberOfPlayers,"basketball");
        }
        else if(type.equals("football")) {
            return new FootballTeam(teamName,gender,numberOfPlayers,"football");
        }
        return null;
    }
}