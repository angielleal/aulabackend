package com.example.demo.models;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    private String nome;
    private Double saldo;
    private String senha;
  }
