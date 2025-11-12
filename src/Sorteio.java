import java.util.Random;
import java.util.ArrayList;

public class Sorteio {
    public static ArrayList<Time> sortearTimes(ArrayList<Time> times) {
        Random random = new Random();
        ArrayList<Time> sorteados = new ArrayList<Time>();
        ArrayList<Time> copiaTimes = new ArrayList<Time>(times);

        while (!copiaTimes.isEmpty()) {
            int index = random.nextInt(copiaTimes.size());
            Time timeEscolhido = copiaTimes.remove(index);
            sorteados.add(timeEscolhido);
        }

        return sorteados;
    }
}