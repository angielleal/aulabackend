package com.example.exercicio09.dto;

public class ProdutoRequestDTO {
    private String nome;
    private Double preco;

    // Constructor
    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para preco
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
