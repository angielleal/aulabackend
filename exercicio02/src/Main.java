
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        jogadorGerador gera = new jogadorGerador();

        ArrayList<jogador> jogadores = gera.GerardorJogadores();

        System.out.println(jogadores.get((int) Math.floor(Math.random() * 12)).getDescricao());
    }
}