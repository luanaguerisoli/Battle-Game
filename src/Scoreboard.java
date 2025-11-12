import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {
    private List<Team> teams;

    public Scoreboard(List<Team> teams) {
        this.teams = teams;
    }

    public void showResults() {
    System.out.println("\n=== Results Table ===");
        int nameWidth = "Team".length();
        for (Team t : teams) {
            if (t.getName().length() > nameWidth) nameWidth = t.getName().length();
        }
        nameWidth = Math.min(Math.max(nameWidth + 2, 10), 40); // padding e cap

    System.out.println(String.format("%-" + nameWidth + "s %8s %8s %12s %8s", "Team", "Blots", "Plifs", "Advrunghs", "Points"));

        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team team1, Team team2) {
                return team2.getPoints() - team1.getPoints();
            }
        });

        String rowFormat = "%-" + nameWidth + "s %8d %8d %12d %8d";
        for (Team team : teams) {
            System.out.println(String.format(rowFormat,
                    team.getName(), team.getBlots(), team.getPlifs(), team.getAdvrunghs(), team.getPoints()));
        }
    }
}

