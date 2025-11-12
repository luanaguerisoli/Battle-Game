import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("BALLIT CHAMPIONSHIP");
            System.out.println("Choose an option:");
            System.out.println("1. Start a new tournament");
            System.out.println("2. View previous results");
            System.out.println("3. Exit");

            int menu = 0;
            if (sc.hasNextInt()) { menu = sc.nextInt(); sc.nextLine();
            } else {
                System.out.println("Invalid option. Enter a number.");
                sc.nextLine();  continue; }

            switch (menu){
                case 1:
                    int numTeams = 0;
                    System.out.println("Enter the number of teams in the tournament. The number must be even, >= 8 and <= 16.");

                    while (numTeams % 2 != 0 || numTeams < 8 || numTeams> 16) {
                        if (sc.hasNextInt()) {
                            numTeams= sc.nextInt();
                            if (numTeams% 2 == 0 && numTeams>= 8 && numTeams<= 16) {
                                sc.nextLine(); //
                                break;
                            }
                        }
                        System.out.println("Invalid number. Enter again.");
                        sc.nextLine();
                    }

                    ArrayList<Team> teams = new ArrayList<Team>();

                    for (int i = 0; i < numTeams;i++){
                        String name = "";
                        String battleCry = "";
                        int year = 0;

                        while (name.isEmpty()) {
                            System.out.println("Enter the team name: " + (i + 1) + ": ");
                            name = sc.nextLine().trim();
                            if (name.isEmpty()) {
                                System.out.println("Team name cannot be empty. Try again.");
                            }
                        }

                        while (battleCry.isEmpty()) {
                            System.out.println("Enter the battle cry of team: " + (i + 1) + ": ");
                            battleCry = sc.nextLine().trim();
                            if (battleCry.isEmpty()) {
                                System.out.println("Battle cry cannot be empty. Try again.");
                            }
                        }

                        boolean validYear = false;
                        while (!validYear) {
                            System.out.println("Enter the founding year of team: " + (i + 1) + ": ");
                            if (sc.hasNextInt()) {
                                year = sc.nextInt();
                                sc.nextLine();
                                validYear = true;
                            } else {
                                System.out.println("Invalid number. Try again.");
                                sc.nextLine();
                            }
                        }

                        teams.add(new Team(name, battleCry, year));
                    }

                    Phases phases = new Phases(teams);
                    phases.start();

                    Scoreboard scoreboard = new Scoreboard(teams);
                    scoreboard.showResults();

                    System.out.println("Do you want to save the tournament results? (y/n)");
                    String save = sc.nextLine().trim().toLowerCase();

                    if (save.equals("yes") || save.equals("y")) {
                        System.out.println("What filename should be used to save?");
                        String arquiveName = sc.nextLine().trim();
                        while (arquiveName.isEmpty()) {
                            System.out.println("Filename cannot be empty. Try again.");
                            arquiveName = sc.nextLine().trim();
                        }
                        if (!arquiveName.endsWith(".txt")) {
                            arquiveName += ".txt";
                        }
                        ArchivesData.saveTeamsToFile(arquiveName, teams);
                        System.out.println("Results saved successfully as " + arquiveName);
                    } else {
                        System.out.println("Results were not saved.");
                    }

                    break;

                case 2:
                    System.out.println("---------Enter the filename to load:");
                    String downloadArchiveName = sc.nextLine().trim();
                    while (true) {
                        if (!downloadArchiveName.isEmpty()) {
                            if (!downloadArchiveName.endsWith(".txt")) {
                                downloadArchiveName += ".txt";
                            }
                            List<Team> lateTeams = ArchivesData.loadTeamsFromFile(downloadArchiveName);
                            Scoreboard lateScoreboards = new Scoreboard(lateTeams);
                            lateScoreboards.showResults();
                            break;
                        } else {
                            System.out.println("Filename cannot be empty. Try again.");
                            downloadArchiveName = sc.nextLine();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Choose 1, 2 or 3.");
                    break;
            }
        }
    }
}
