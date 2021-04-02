import java.util.ArrayList;

public class Competition {
    String type;
    String gender;
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Team> clasament = new ArrayList<>();

    /**
     *
     * @param type type of a competition
     * @param gender gender of players in competition
     * @param teams lists of all team in a competition
     */
    public Competition(String type, String gender, ArrayList<Team> teams) {
        this.type = type;
        this.gender = gender;
        this.teams = teams;
    }
    void set_clasamet(ArrayList<Team> clasament) {
        this.clasament =  clasament;
    }
}