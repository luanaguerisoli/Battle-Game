import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoDados {

    public static void salvarTimesEmArquivo(String caminhoArquivo, List<Time> times) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Time time : times) {
                writer.write(time.exportarDadosString());
                writer.newLine();
            }
            System.out.println("Resultados salvos com sucesso em " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os resultados: " + e.getMessage());
        }
    }

    public static List<Time> carregarTimesDeArquivo(String caminhoArquivo) {
        List<Time> times = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Divida a linha em partes e crie o Time
                String[] partes = linha.split(",");
                Time time = Time.criarDeDadosDoArquivo(List.of(partes));
                if (time != null) {
                    times.add(time);
                }
            }
            System.out.println("Dados dos times carregados com sucesso de " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao carregar os times: " + e.getMessage());
        }
        return times;
    }
}
