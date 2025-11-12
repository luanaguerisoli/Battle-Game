import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true){
            System.out.println("BALLIT CHAMPIONSHIP");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Iniciar um novo campeonato");
            System.out.println("2. Ver resultados anteriores");
            System.out.println("3. Sair");

            int menu = 0;
            if (sc.hasNextInt()) { menu = sc.nextInt(); sc.nextLine();
            } else {
                System.out.println("Opção inválida. Digite um número.");
                sc.nextLine();  continue; }

            switch (menu){
                case 1:
                    int numTimes = 0;
                    System.out.println("Digite a quantidade de times presentes no campeonato. O número deve ser par, maior que 8 e menor que 16.");

                    while (numTimes % 2 != 0 || numTimes < 8 || numTimes > 16) {
                        if (sc.hasNextInt()) {
                            numTimes = sc.nextInt();
                            if (numTimes % 2 == 0 && numTimes >= 8 && numTimes <= 16) {
                                sc.nextLine(); // consumir newline restante antes de ler nomes
                                break;
                            }
                        }
                        System.out.println("Número inválido. Digite novamente.");
                        sc.nextLine();
                    }

                    ArrayList<Time> times = new ArrayList<Time>();

                    for (int i = 0; i < numTimes; i++) {
                        String nome = "";
                        String grito = "";
                        int ano = 0;

                        while (nome.isEmpty()) {
                            System.out.println("Digite o nome do time " + (i + 1) + ": ");
                            nome = sc.nextLine().trim();
                            if (nome.isEmpty()) {
                                System.out.println("Nome do time não pode ser vazio. Tente novamente.");
                            }
                        }

                        while (grito.isEmpty()) {
                            System.out.println("Digite o grito de guerra do time " + (i + 1) + ": ");
                            grito = sc.nextLine().trim();
                            if (grito.isEmpty()) {
                                System.out.println("Grito de guerra não pode ser vazio. Tente novamente.");
                            }
                        }

                        boolean anoValido = false;
                        while (!anoValido) {
                            System.out.println("Digite o ano de fundação do time " + (i + 1) + ": ");
                            if (sc.hasNextInt()) {
                                ano = sc.nextInt();
                                sc.nextLine();
                                anoValido = true;
                            } else {
                                System.out.println("Número inválido. Tente novamente.");
                                sc.nextLine();
                            }
                        }

                        times.add(new Time(nome, grito, ano));
                    }

                    Fases fases = new Fases(times);
                    fases.iniciar();

                    Tabela tabela = new Tabela(times);
                    tabela.Resultados();

                    System.out.println("Deseja salvar os resultados do campeonato? (s/n)");
                    String salvar = sc.nextLine().trim().toLowerCase();

                    if (salvar.equals("sim") || salvar.equals("s")) {
                        System.out.println("Deseja salvar com qual nome?");
                        String nomeArquivo = sc.nextLine().trim();
                        while (nomeArquivo.isEmpty()) {
                            System.out.println("Nome do arquivo não pode ser vazio. Tente novamente.");
                            nomeArquivo = sc.nextLine().trim();
                        }
                        if (!nomeArquivo.endsWith(".txt")) {
                            nomeArquivo += ".txt";
                        }
                        ArquivoDados.salvarTimesEmArquivo(nomeArquivo, times);
                        System.out.println("Resultados salvos com sucesso em " + nomeArquivo);
                    } else {
                        System.out.println("Resultados não foram salvos.");
                    }

                    break; // evita cair no case 2

                case 2:
                    System.out.println("---------Digite o nome do arquivo para carregar:");
                    String nomeArquivoCarregar = sc.nextLine().trim();
                    while (true) {
                        if (!nomeArquivoCarregar.isEmpty()) {
                            if (!nomeArquivoCarregar.endsWith(".txt")) {
                                nomeArquivoCarregar += ".txt";
                            }
                            List<Time> timesAnteriores = ArquivoDados.carregarTimesDeArquivo(nomeArquivoCarregar);
                            Tabela tabelaAnteriores = new Tabela(timesAnteriores);
                            tabelaAnteriores.Resultados();
                            break;
                        } else {
                            System.out.println("Nome do arquivo não pode ser vazio. Tente novamente.");
                            nomeArquivoCarregar = sc.nextLine();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Escolha 1, 2 ou 3.");
                    break;
            }
        }
    }
}
