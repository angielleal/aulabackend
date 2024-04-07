package com.example.jogador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.Random;

@SpringBootApplication
public class WebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }

}

@RestController
class MensagemController {

    @GetMapping("/mensagem")
    public String obterMensagem() {
        return "Esta é uma mensagem aleatória gerada pelo web service!";
    }
}

@RestController
class JogadorController {

    private final String[] nomes = {"João", "Maria", "José", "Ana", "Pedro"};
    private final String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Pereira", "Souza"};
    private final String[] posicoes = {"Atacante", "Meio-campo", "Defensor", "Goleiro"};
    private final String[] clubes = {"Clube A", "Clube B", "Clube C", "Clube D", "Clube E"};

    @GetMapping("/jogador")
    public Jogador obterJogador() {
        Random random = new Random();
        String nome = nomes[random.nextInt(nomes.length)];
        String sobrenome = sobrenomes[random.nextInt(sobrenomes.length)];
        String posicao = posicoes[random.nextInt(posicoes.length)];
        String clube = clubes[random.nextInt(clubes.length)];
        return new Jogador(nome, sobrenome, posicao, clube);
    }

    static class Jogador {
        private final String nome;
        private final String sobrenome;
        private final String posicao;
        private final String clube;

        public Jogador(String nome, String sobrenome, String posicao, String clube) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.posicao = posicao;
            this.clube = clube;
        }

        // Getters
        public String getNome() {
            return nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public String getPosicao() {
            return posicao;
        }

        public String getClube() {
            return clube;
        }
    }
}
