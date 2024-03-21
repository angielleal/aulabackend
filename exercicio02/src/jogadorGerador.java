import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class jogadorGerador {
    private final String listaNomes = retornaLista("https://venson.net.br/resources/data/nomes.txt");
    private final String listaSobrenomes = retornaLista("https://venson.net.br/resources/data/sobrenomes.txt");
    private final String listaPosicoes = retornaLista("https://venson.net.br/resources/data/posicoes.txt");
    private final String listaClubes = retornaLista("https://venson.net.br/resources/data/clubes.txt");

    public jogadorGerador() throws Exception {
    }

    private static String retornaNumeroAleatorio(String dados) {
        String[] listaNomes = dados.split("\n");
        int indiceAle = (int) Math.floor(Math.random() * listaNomes.length);
        return listaNomes[indiceAle];
    }

    private static String retornaLista(String Uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public ArrayList<jogador> GerardorJogadores(){
        ArrayList<jogador> listaJogadores = new ArrayList<jogador>();
        for(int i = 0; i < 11; i++){
            String nome = retornaNumeroAleatorio(this.listaNomes);
            nome = nome.substring(0, 1) + nome.substring(1).toLowerCase();

            String[] nomes = (nome).split("\\s+");

            StringBuilder nomesCapitalizados = new StringBuilder();
            for (String palavra : nomes) {
                nomesCapitalizados.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1).toLowerCase()).append(" ");
            }
            nome = nomesCapitalizados.toString().trim();

            String sobrenome = retornaNumeroAleatorio(this.listaSobrenomes);
            sobrenome = Character.toUpperCase(sobrenome.charAt(0)) + sobrenome.substring(1).toLowerCase();

            String posicao = retornaNumeroAleatorio(this.listaPosicoes).replaceAll("[^a-zA-Z\\s-]", "");

            String clube = retornaNumeroAleatorio(this.listaClubes);

            int idade = (int) Math.floor(Math.random() * 24) + 17;

            jogador jogador = new jogador(
                    nome=nome,

                    sobrenome=sobrenome,

                    posicao=posicao,

                    idade=idade,

                    clube=clube
            );
            listaJogadores.add(jogador);
        }
        return listaJogadores;
    }

}

