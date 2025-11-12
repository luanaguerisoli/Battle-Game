import java.util.Random;
import java.util.Scanner;

public class Partida{

    public Time time1;
    public Time time2;

    public Partida(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
    }

    public Time jogar() {
        Scanner sc = new Scanner(System.in);
        time1.resetarPontos();
        time2.resetarPontos();

        System.out.println("Partida: " + time1.getnome() + " vs " + time2.getnome());

        while (true) {
            System.out.println("Pontuação atual: ");
            System.out.println(time1.getnome() + ": " + time1.getpontos() + " pontos");
            System.out.println(time2.getnome() + ": " + time2.getpontos() + " pontos");

            System.out.println("1. Registrar Blot para " + time1.getnome());
            System.out.println("2. Registrar Blot para " + time2.getnome());
            System.out.println("3. Registrar Plif para " + time1.getnome());
            System.out.println("4. Registrar Plif para " + time2.getnome());
            System.out.println("5. Registrar Advrungh para " + time1.getnome());
            System.out.println("6. Registrar Advrungh para " + time2.getnome());
            System.out.println("7. Finalizar partida");

            int menu = 0;
            if (sc.hasNextInt()) { menu = sc.nextInt(); sc.nextLine();
            } else {
                System.out.println("Opção inválida. Digite um número.");
                sc.nextLine();  continue; }

            switch (menu){
                case 1: time1.registroBlot(); break;
                case 2: time2.registroBlot(); break;
                case 3: time1.registroPlif(); break;
                case 4: time2.registroPlif(); break;
                case 5: time1.registroAdvrungh(); break;
                case 6: time2.registroAdvrungh(); break;
                case 7: return vencedor();
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    private Time vencedor(){
        System.out.println("Pontuação final:");
        System.out.println(time1.getnome() + ": " + time1.getpontos() + " pontos");
        System.out.println(time2.getnome() + ": " + time2.getpontos() + " pontos");

        if (time1.getpontos() > time2.getpontos()) {
            System.out.println("Vencedor: " + time1.getnome()); return time1;
        } else if (time2.getpontos() > time1.getpontos()) {
            System.out.println("Vencedor: " + time2.getnome()); return time2;
        } else { return grusht(); }
    }
    private Time grusht(){
        Random r = new Random();
        System.out.println("Empate! Será necessário realizar o Grusht!");
        System.out.println(time1.getgrito()+" ! "+time1.getgrito() +" ! "+time1.getgrito() +"!");
        System.out.println(time2.getgrito()+ " ! "+time2.getgrito()+" ! "+time2.getgrito() +"!");
        int escolha = r.nextInt(2);

        if (escolha == 0){
            System.out.println("Parabéns ao time " + time1.getnome() + ", vocês gritaram mais alto!");
            time1.registroGrusht(); return time1;
        } else {
            System.out.println("Parabéns ao time " + time2.getnome() + ", vocês gritaram mais alto!");
            time2.registroGrusht(); return time2;
        }
    }
}