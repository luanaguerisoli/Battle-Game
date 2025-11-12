import java.util.Random;
import java.util.Scanner;

public class Match {

    public Team team1;
    public Team team2;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public Team play() {
        Scanner sc = new Scanner(System.in);
        team1.resetPoints();
        team2.resetPoints();

    System.out.println("Match: " + team1.getName() + " vs " + team2.getName());

        while (true) {
            System.out.println("Current score:");
            System.out.println(team1.getName() + ": " + team1.getPoints() + " points");
            System.out.println(team2.getName() + ": " + team2.getPoints() + " points");

            System.out.println("1. Register Blot for " + team1.getName());
            System.out.println("2. Register Blot for " + team2.getName());
            System.out.println("3. Register Plif for " + team1.getName());
            System.out.println("4. Register Plif for " + team2.getName());
            System.out.println("5. Register Advrungh for " + team1.getName());
            System.out.println("6. Register Advrungh for " + team2.getName());
            System.out.println("7. End match");

            int menu = 0;
            if (sc.hasNextInt()) { menu = sc.nextInt(); sc.nextLine();
            } else {
                System.out.println("Invalid option. Enter a number.");
                sc.nextLine();  continue; }

            switch (menu){
                case 1: team1.registerBlot(); break;
                case 2: team2.registerBlot(); break;
                case 3: team1.registerPlif(); break;
                case 4: team2.registerPlif(); break;
                case 5: team1.registerAdvrungh(); break;
                case 6: team2.registerAdvrungh(); break;
                case 7: return winner();
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }
    private Team winner(){
        System.out.println("Final score:");
        System.out.println(team1.getName() + ": " + team1.getPoints() + " points");
        System.out.println(team2.getName() + ": " + team2.getPoints() + " points");

        if (team1.getPoints() > team2.getPoints()) {
            System.out.println("Winner: " + team1.getName()); return team1;
        } else if (team2.getPoints() > team1.getPoints()) {
            System.out.println("Winner: " + team2.getName()); return team2;
        } else { return grushtTieBreak(); }
    }
    private Team grushtTieBreak(){
        Random r = new Random();
        System.out.println("Tie! A Grusht is required!");
        System.out.println(team1.getBattleCry()+" ! "+ team1.getBattleCry() +" ! "+ team1.getBattleCry() +"!");
        System.out.println(team2.getBattleCry()+ " ! "+ team2.getBattleCry()+" ! "+ team2.getBattleCry() +"!");
        int escolha = r.nextInt(2);

        if (escolha == 0){
            System.out.println("Congratulations to team " + team1.getName() + ", you shouted louder!");
            team1.registerGrusht(); return team1;
        } else {
            System.out.println("Congratulations to team " + team2.getName() + ", you shouted louder!");
            team2.registerGrusht(); return team2;
        }
    }
}