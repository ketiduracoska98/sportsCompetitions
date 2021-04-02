import java.util.ArrayList;
import java.util.Collections;

public class Team implements CalculateScore, Observer {
    String teamName;
    String gender;
    int numberOfPlayers;
    int points;
    ArrayList<Player> players_list = new ArrayList<>();
    // constructor
    public Team(String teamName, String gender, int numberOfPlayers) {
        this.teamName = teamName;
        this.gender = gender;
        this.numberOfPlayers = numberOfPlayers;
    }
    // create a list of players
    @Override
     public void set_list (ArrayList<Player> players_list)
    {
       this.players_list = players_list;
    }

    // methods for visitor desing patter
    @Override
    public double accept(Team team, String type, String gender) {
        return team.visit(this,type,gender);
    }

    // calcule the score of all players 
    @Override
    public double visit(Team team, String type, String gender) {

        int i, max = 0, min = 200, sum = 0, prod = 1;
        double score = 0;
        
        if(type.equals("football") && gender.equals("masculin")) {
            for(i = 0; i < team.players_list.size(); i++) {
                sum += team.players_list.get(i).score;
               if(team.players_list.get(i).score > max) {
                   max = team.players_list.get(i).score;
               }
            }
            max *= 2;
            score = max + sum;
        }
        if(type.equals("football") && gender.equals("feminin")) {
            for(i = 0; i < team.players_list.size(); i++) {
                sum += team.players_list.get(i).score;
                if(team.players_list.get(i).score < min) {
                    min = team.players_list.get(i).score;
                }
            }
            min *= 2;
            score = min + sum;
        }
        if(type.equals("basketball")) {
            for(i = 0; i < team.players_list.size(); i++) {
                sum += team.players_list.get(i).score;
            }
            score = sum / team.numberOfPlayers;
        }
        if(type.equals("handball") && gender.equals("masculin")) {
            for(i = 0; i < team.players_list.size(); i++) {
                sum += team.players_list.get(i).score;
            }
            score = sum;
        }
        if(type.equals("handball") && gender.equals("feminin")) {
            for(i = 0; i < team.players_list.size(); i++) {
                prod *= team.players_list.get(i).score;
            }
            score = prod;
        }

        return score;
    }

    // method that set points of a team
    public void set_points(int points){
        this.points = points;
    }

    /* notify all teams for its position in a competition 
     with sorting the list of all teams */
    @Override
    public ArrayList notifyObservers(ArrayList<Team> teams) {
        int i,j;
        for(i = 0; i < teams.size(); i++) {
            for (j= i + 1; j < teams.size(); j++) {
                if(teams.get(i).points < teams.get(j).points) {
                    Collections.swap(teams, i,j);
                }
            }
        }
        return teams;
    }
}
