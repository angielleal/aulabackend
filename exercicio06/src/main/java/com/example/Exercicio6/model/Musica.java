package com.example.Exercicio6.model;

import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Embeddable
public class Musica {
    private String nome;
    private String cantor;
    private int duracao;  // duração em segundos
    private LocalDate dataCriacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
}
