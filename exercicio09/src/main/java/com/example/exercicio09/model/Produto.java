package com.example.exercicio09.model;

@jakarta.persistence.Entity
public class Produto {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;

    // Constructor vazio é necessário para o Hibernate
    public Produto() {}

    // Constructor para facilitar a criação do objeto
    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getter e setter para 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e setter para 'nome'
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e setter para 'preco'
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
