import java.util.ArrayList;
import java.util.List;

public class Team {
    public String name;
    public String battleCry;
    public int year;
    public int points;
    public int blots;
    public int plifs;
    public int advrunghs;
    public int grusht;

    public Team(String name, String battleCry, int year) {
        this.name = name;
        this.battleCry = battleCry;
        this.year = year;
        this.points = 50;
        this.blots = 0;
        this.plifs = 0;
        this.advrunghs = 0;
        this.grusht = 0;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBattleCry() { return battleCry; }
    public void setBattleCry(String battleCry) { this.battleCry = battleCry; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
    public int getBlots() { return blots; }
    public void setBlots(int blots) { this.blots = blots; }
    public int getPlifs() { return plifs; }
    public void setPlifs(int plifs) { this.plifs = plifs; }
    public int getAdvrunghs() { return advrunghs; }
    public void setAdvrunghs(int advrunghs) { this.advrunghs = advrunghs; }
    public int getGrusht() { return grusht; }
    public void setGrusht(int grusht) { this.grusht = grusht; }

    public void resetPoints() { points = 50; }
    public void registerBlot() { blots++; points += 5; }
    public void registerPlif() { plifs++; points += 1; }
    public void registerAdvrungh() { advrunghs++; points -= 10; }
    public void registerGrusht() { grusht++; points += 3; }

    public List<String> exportData() {
        List<String> data = new ArrayList<String>();
        data.add(name);
        data.add(battleCry);
        data.add(String.valueOf(year));
        data.add(String.valueOf(blots));
        data.add(String.valueOf(plifs));
        data.add(String.valueOf(advrunghs));
        data.add(String.valueOf(points));
        return data;
    }

    public String exportDataString() {
        return String.join(",", exportData());
    }

    public static Team createFromFileData(List<String> data) {
        try {
            String name = data.get(0);
            String battleCry = data.get(1);
            int year = Integer.parseInt(data.get(2));
            int blots = Integer.parseInt(data.get(3));
            int plifs = Integer.parseInt(data.get(4));
            int advrunghs = Integer.parseInt(data.get(5));
            int points = Integer.parseInt(data.get(6));

            Team t = new Team(name, battleCry, year);
            t.blots = blots;
            t.plifs = plifs;
            t.advrunghs = advrunghs;
            t.points = points;
            return t;
        } catch (Exception e) {
            System.out.println("Error creating team from data: " + e.getMessage());
            return null;
        }
    }

    public Team importData(List<String> data) {
        this.name = data.get(0);
        this.battleCry = data.get(1);
        this.year = Integer.parseInt(data.get(2));
        this.blots = Integer.parseInt(data.get(3));
        this.plifs = Integer.parseInt(data.get(4));
        this.advrunghs = Integer.parseInt(data.get(5));
        this.points = Integer.parseInt(data.get(6));
        return this;
    }
}
