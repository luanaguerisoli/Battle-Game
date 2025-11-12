import java.util.Random;
import java.util.ArrayList;

public class Draw {
    public static ArrayList<Team> drawTeams(ArrayList<Team> teams) {
        Random random = new Random();
        ArrayList<Team> drawn = new ArrayList<Team>();
        ArrayList<Team> copy = new ArrayList<Team>(teams);

        while (!copy.isEmpty()) {
            int index = random.nextInt(copy.size());
            Team selected = copy.remove(index);
            drawn.add(selected);
        }

        return drawn;
    }
}