package com.example.demo.models;
import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transacao {

    
    @NotBlank(message = "É obrigatório informar o recebedor")
    private String recebedor;

    @NotBlank(message = "É obrigatório informar o pagador")
    private String pagador;

    @NotNull(message = "É obrigatório informar a quantidade")
    @Positive(message = "A quantidade deve ser maior que 0")
    private Double quantidade;
  }