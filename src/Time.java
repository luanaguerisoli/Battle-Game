import java.util.ArrayList;
import java.util.List;

public class Time {
    public String nome;
    public String grito;
    public int ano;
    public int pontos;
    public int blots;
    public int plifs;
    public int advrunghs;
    public int grusht;

    public Time(String nome, String grito, int ano) {
        this.nome = nome;
        this.grito = grito;
        this.ano = ano;
        this.pontos = 50;
        this.blots = 0;
        this.plifs = 0;
        this.advrunghs = 0;
        this.grusht = 0;
    }

    public String getnome() {return nome;}
    public void setnome(String nome) {this.nome = nome;}
    public String getgrito() {return grito;}
    public void setgrito(String grito) {this.grito = grito;}
    public int getano() {return ano;}
    public void setano(int ano) {this.ano = ano;}
    public int getpontos() {return pontos;}
    public void setpontos(int pontos) {this.pontos = pontos;}
    public int getblots() {return blots;}
    public void setblots(int blots) {this.blots = blots;}
    public int getplifs() {return plifs;}
    public void setplifs(int plifs) {this.plifs = plifs;}
    public int getadvrunghs() {return advrunghs;}
    public void setadvrunghs(int advrunghs) {this.advrunghs = advrunghs;}
    public int getgrusht() {return grusht;}
    public void setgrusht(int grusht) {this.grusht = grusht;}

    public void resetarPontos() { pontos = 50;}
    public void registroBlot() { blots++; pontos+= 5;}
    public void registroPlif() { plifs++; pontos+= 1;}
    public void registroAdvrungh() { advrunghs++; pontos-= 10;}
    public void registroGrusht() { grusht++; pontos += 3;}

    public List<String> exportarDados() {
        List<String> dadosTime = new ArrayList<String>();
        dadosTime.add(nome);
        dadosTime.add(grito);
        dadosTime.add(String.valueOf(ano));
        dadosTime.add(String.valueOf(blots));
        dadosTime.add(String.valueOf(plifs));
        dadosTime.add(String.valueOf(advrunghs));
        dadosTime.add(String.valueOf(pontos));
        return dadosTime;
    }
    public String exportarDadosString() {
        return String.join(",", exportarDados());
    }

    public static Time criarDeDadosDoArquivo(List<String> dadosTime) {
        try {
            String nome = dadosTime.get(0);
            String grito = dadosTime.get(1);
            int ano = Integer.parseInt(dadosTime.get(2));
            int blots = Integer.parseInt(dadosTime.get(3));
            int plifs = Integer.parseInt(dadosTime.get(4));
            int advrunghs = Integer.parseInt(dadosTime.get(5));
            int pontos = Integer.parseInt(dadosTime.get(6));

            Time time = new Time(nome, grito, ano);
            time.blots = blots;
            time.plifs = plifs;
            time.advrunghs = advrunghs;
            time.pontos = pontos;
            return time;
        } catch (Exception e) {
            System.out.println("Erro ao criar time a partir dos dados: " + e.getMessage());
            return null;
        }
    }

    public Time importarDados(List<String> dadosTime) {
        this.nome = dadosTime.get(0);
        this.grito = dadosTime.get(1);
        this.ano = Integer.parseInt(dadosTime.get(2));
        this.blots = Integer.parseInt(dadosTime.get(3));
        this.plifs = Integer.parseInt(dadosTime.get(4));
        this.advrunghs = Integer.parseInt(dadosTime.get(5));
        this.pontos = Integer.parseInt(dadosTime.get(6));
        return this;
    }
}
