package com.example.demo.models;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transacao {
    private String recebedor;
    private String pagador;
    private Double quantidade;
  }