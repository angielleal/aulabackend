package org.exemple;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] GetDados = {"nomes", "sobrenomes", "posicoes", "clubes"};
        String[] Arr = null;
        int idade= 0;
        Stack<String> dadoAleatorio = new Stack<String>();

        for (int i = 0; i <= 3; i++) {
            Arr = Requisicao("https://venson.net.br/resources/data/" + GetDados[i] + ".txt");
            dadoAleatorio.push(NumeroAleatorio(Arr));
        }
        idade = Idade();
        System.out.println(dadoAleatorio.elementAt(0) +" "+ dadoAleatorio.elementAt(1) +
                " é um futebolista brasileiro de "+idade+" anos que atua como " + dadoAleatorio.elementAt(2) +
                ". Atualmente defende o " + dadoAleatorio.elementAt(3));
    }

    private static String[] Requisicao(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String lista = response.body();

        return lista.split("\n");
    }

    private static String NumeroAleatorio(String[] Arr) throws Exception {
        double aleatorio = Math.random();
        double numeroMultiplicado = aleatorio * Arr.length;
        int numeroTruncado = (int) Math.floor(numeroMultiplicado);
        String valor = Arr[numeroTruncado];
        String teste = valor.replaceAll("\"", "").replace(",", "");
        return teste;
    }

    private static int Idade() throws Exception {
        int max = 42;
        int min = 17;
        Random aleatorio = new Random();
        int Idade = aleatorio.nextInt((max - min) + 1) + min;
        return Idade;
    }
}
