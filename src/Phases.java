import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Phases {
    private ArrayList<Team> teams;
    private int round;

    public Phases(ArrayList<Team> teams) {
        this.teams = teams;
        this.round = 1;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (teams.size() > 1) {
            System.out.println("\n=== Round " + round + " ===");

            ArrayList<Team> drawnTeams = Draw.drawTeams(teams);
            ArrayList<Match> matches = new ArrayList<Match>();

            for (int i = 0; i < drawnTeams.size(); i += 2) {
                Team team1 = drawnTeams.get(i);
                Team team2 = drawnTeams.get(i + 1);
                Match match = new Match(team1, team2);
                matches.add(match);
                System.out.println("Match: " + team1.getName() + " vs " + team2.getName()); }

            ArrayList<Team> winners = new ArrayList<Team>();

            while (!matches.isEmpty()) {
                int choice = -1;
                while (true){
                        try{
                        System.out.println("\nChoose a match to manage (1 to " + matches.size() + "): ");
                        for (int i = 0; i < matches.size(); i++) {
                            Match m = matches.get(i);
                            System.out.println((i + 1) + ". " + m.team1.getName() + " vs " + m.team2.getName());
                        }

                        choice = sc.nextInt() - 1;
                        if (choice >= 0 && choice < matches.size()) {
                            break;
                        } else {
                            System.out.println("Invalid choice! Try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid number. Try again.");
                        sc.nextLine();
                    }
                }
                Match selectedMatch = matches.remove(choice);
                Team winner = selectedMatch.play();
                winners.add(winner);
            }
            teams = winners; round++; }
        announceChampion();
    }

    private void announceChampion() {
        Team champion = teams.get(0);
        System.out.println("\n=== End of Tournament ===");
        System.out.println("Congratulations to the winning team: " + champion.getName());
        System.out.println(champion.getBattleCry());
    }
}

