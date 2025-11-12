import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tabela {
    private List<Time> times;

    public Tabela(List<Time> times) {
        this.times = times;
    }

    public void Resultados() {
        System.out.println("\n=== Tabela de Resultados ===");
        // calcular largura da coluna de nome (maior entre "Time" e nomes)
        int nameWidth = "Time".length();
        for (Time t : times) {
            if (t.getnome().length() > nameWidth) nameWidth = t.getnome().length();
        }
        nameWidth = Math.min(Math.max(nameWidth + 2, 10), 40); // padding e cap

        String headerFormat = String.format("%%-%ds %8s %8s %12s %8s", nameWidth, "Blots", "Plifs", "Advrunghs", "Total");
        System.out.println(String.format("%-" + nameWidth + "s %8s %8s %12s %8s", "Time", "Blots", "Plifs", "Advrunghs", "Pontuação"));

        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time time1, Time time2) {
                return time2.getpontos() - time1.getpontos();
            }
        });

        String rowFormat = "%-" + nameWidth + "s %8d %8d %12d %8d";
        for (Time time : times) {
            System.out.println(String.format(rowFormat,
                    time.getnome(), time.getblots(), time.getplifs(), time.getadvrunghs(), time.getpontos()));
        }
    }
}

