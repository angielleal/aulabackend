package org.example;

public class Filme implements Indicavel {
    private boolean elegivel;
    private int numeroDeIndicacoes;
    private String titulo;

    public Filme(boolean elegivel, String titulo) {
        this.elegivel = elegivel;
        this.numeroDeIndicacoes = 0;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Implementação do método getNome() da interface Indicavel
    @Override
    public String getNome() {
        // Como o título do filme serve como seu nome, retornamos o título aqui
        return titulo;
    }
}
