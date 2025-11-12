import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class Fases {
    private ArrayList<Time> times;
    private int rodada;

    private List<List<Time>> pastResults = new ArrayList<>();

    public Fases(ArrayList<Time> times) {
        this.times = times;
        this.rodada = 1;
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);

        while (times.size() > 1) {
            System.out.println("\n=== Rodada " + rodada + " ===");

            ArrayList<Time> timesSorteados = Sorteio.sortearTimes(times);
            ArrayList<Partida> partidas = new ArrayList<Partida>();

            for (int i = 0; i < timesSorteados.size(); i += 2) {
                Time time1 = timesSorteados.get(i);
                Time time2 = timesSorteados.get(i + 1);
                Partida partida = new Partida(time1, time2);
                partidas.add(partida);
                System.out.println("Partida: " + time1.getnome() + " vs " + time2.getnome()); }

            ArrayList<Time> vencedores = new ArrayList<Time>();

            while (!partidas.isEmpty()) {
                int escolha = -1;
                while (true){
                    try{
                        System.out.println("\nEscolha uma partida para administrar (1 a " + partidas.size() + "):");
                        for (int i = 0; i < partidas.size(); i++) {
                            Partida p = partidas.get(i);
                            System.out.println((i + 1) + ". " + p.time1.getnome() + " vs " + p.time2.getnome());
                        }

                        escolha = sc.nextInt() - 1;
                        if (escolha >= 0 && escolha < partidas.size()) {
                            break;
                        } else {
                            System.out.println("Escolha inválida! Tente novamente.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Número inválido. Tente novamente.");
                        sc.nextLine();
                    }
                }
                Partida partidaEscolhida = partidas.remove(escolha);
                Time vencedor = partidaEscolhida.jogar();
                vencedores.add(vencedor);
            }
            times = vencedores; rodada++; }
        VencedorFinal();
    }

    private void VencedorFinal() {
        Time campeao = times.get(0);
        System.out.println("\n=== Fim do Campeonato ===");
        System.out.println("Parabéns ao time vencedor: " + campeao.getnome());
        System.out.println(campeao.getgrito());
    }
}

