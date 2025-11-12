import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivesData {

    public static void saveTeamsToFile(String filePath, List<Team> teams) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Team team : teams) {
                writer.write(team.exportDataString());
                writer.newLine();
            }
            System.out.println("Results saved successfully as " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving results: " + e.getMessage());
        }
    }

    public static List<Team> loadTeamsFromFile(String filePath) {
        List<Team> teams = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Team team = Team.createFromFileData(List.of(parts));
                if (team != null) {
                    teams.add(team);
                }
            }
            System.out.println("Team data loaded successfully from " + filePath);
        } catch (IOException e) {
            System.out.println("Error loading teams: " + e.getMessage());
        }
        return teams;
    }
}
