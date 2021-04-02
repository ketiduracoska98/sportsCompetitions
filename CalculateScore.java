import java.util.ArrayList;
// inteface for implementing Vistor desing pattern
public interface CalculateScore {
    public double accept(Team team, String type, String gender);
    public double visit(Team team, String type, String gender);
    public void set_list(ArrayList<Player> players_list);
}