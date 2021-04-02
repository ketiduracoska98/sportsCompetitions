import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Keti Duracoska 322 CB
 * @since 22.12.2019
 */
public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        File file = new File(args[1]);
        PrintStream file_writer = new PrintStream(args[3]);
        System.setOut(file_writer);
        Scanner scan = new Scanner(file).useDelimiter(",");
        ArrayList<Team> teams = new ArrayList<>();

        String type, teamName, gender, numberOfPlayers,name,score;
        int nrOfPlayers, score_int, i, j;
            while(scan.hasNext()) {
                type = scan.next().trim();
                teamName = scan.next().trim();
                gender = scan.next().trim();
                numberOfPlayers = scan.nextLine().replace(",", " ").trim();
                nrOfPlayers = Integer.parseInt(numberOfPlayers);

                // chossing a team type with Factory and Singleton desing pattern
                Choosetype type_of_team = new Choosetype();
                Team team = type_of_team.team_type(type, teamName, gender, nrOfPlayers);

                if (team == null) {
                    team = HandballTeam.getInstance(teamName, gender, nrOfPlayers, type);
                }
                ArrayList<Player> players = new ArrayList<>();

                for (i = 0; i < nrOfPlayers; i++) {
                    name = scan.next().trim();
                    score = scan.nextLine().replace(",", " ").trim();
                    score_int = Integer.parseInt(score);
                    Player player = new Player(name, score_int);
                    players.add(player);
                    // create a list of players
                }
                // set list of all players
                team.set_list(players);
                // add all teams in a list of teams
                teams.add(team);
                if (args[0].equals("inscriere")) {
                    // prints all teams and its players 
                    System.out.print("{teamName: " + teamName + ", gender: " + gender + ", numberOfPlayers: "
                            + nrOfPlayers + ", players: [");

                    for (i = 0; i < players.size(); i++) {
                        if (i + 1 == nrOfPlayers) {
                            System.out.print("{name: " + team.players_list.get(i).name + ", score: "
                                    + team.players_list.get(i).score + "}");
                        }
                        else {
                            System.out.print("{name: " + team.players_list.get(i).name + ", score: "
                                    + team.players_list.get(i).score + "}, ");
                        }
                    }
                    if (scan.hasNext()) {
                        System.out.println("]}");
                    }
                    else {
                        System.out.print("]}");
                    }
                }
            }
           if(args[0].equals("competitie")) {
            ArrayList<Team> teamsCom = new ArrayList<>();

            File file1 = new File(args[2]);
            Scanner scan1 = new Scanner(file1).useDelimiter(",");
            type = scan1.next().trim();
            gender = scan1.nextLine().replace(","," ").trim();
            while (scan1.hasNext()) {
                teamName = scan1.nextLine();
                for (i = 0; i < teams.size(); i++) {
                    if (teams.get(i).teamName.equals(teamName)) {
                         // add teams in a Competition list
                        teamsCom.add(teams.get(i));
                    }
                }
            }
            Competition com = new Competition(type,gender,teamsCom);
                // calculate and set the score of a team
            int points = 0;
            for(i = 0; i < teamsCom.size(); i++) {
                CalculateScore score1 = new Team(teamsCom.get(i).teamName, gender, teamsCom.get(i).numberOfPlayers);
                score1.set_list(teamsCom.get(i).players_list);
                points = 0;
                for (j = 0; j < teamsCom.size(); j++) {
                    CalculateScore score2 = new Team(teamsCom.get(j).teamName, gender, teamsCom.get(j).numberOfPlayers);
                    score2.set_list(teamsCom.get(j).players_list);
                    if (i != j) {
                        // every team play with other teams and get points based on its score
                        if (score1.accept(teamsCom.get(i), type, gender) > score2.accept(teamsCom.get(j), type, gender)) {
                            points += 3;
                        } else if (score1.accept(teamsCom.get(i), type, gender) == score2.accept(teamsCom.get(j), type, gender)) {
                            points += 1;
                        }
                    }
                }
                teamsCom.get(i).set_points(points);
            }
            ArrayList<Team> teams_clasament = new ArrayList<>(teamsCom);
            com.set_clasamet(teams_clasament);
            teamsCom = teamsCom.get(0).notifyObservers(teamsCom);
            // sort a teams based of a points
            for(i = 0; i < 3; i++){
                // prints firsts three places
                System.out.println(teamsCom.get(i).teamName);
            }
            for(i = 0; i < teams_clasament.size(); i++) {
                for(j = 0; j < teamsCom.size(); j++){
                    if(teams_clasament.get(i).teamName.equals(teamsCom.get(j).teamName)){
                        // prints position of every team
                        System.out.println("Echipa " +com.clasament.get(i).teamName+" a ocupat locul "+(j+1));
                    }
                }
            }
        }
    }
}