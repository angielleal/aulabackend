package org.example;

public class Ator implements Indicavel {
    private boolean elegivel;
    private int numeroDeIndicacoes;
    private String nome;
    public Ator(boolean elegivel, String nome) {
        this.elegivel = elegivel;
        this.numeroDeIndicacoes = 0;
        this.nome = nome;
    }
    public boolean isElegivel() {
        return elegivel;
    }
    public void setElegivel(boolean elegivel) {
        this.elegivel = elegivel;
    }
    public int getNumeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }
    public void incrementarIndicacoes() {
        numeroDeIndicacoes++;
    }
    @Override
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    // Implementação do método getTitulo() da interface Indicavel
    @Override
    public String getTitulo() {
        // Neste caso, como é um Ator, retornamos null ou uma string vazia,
        // dependendo do contexto do seu projeto
        return "";
    }
}
