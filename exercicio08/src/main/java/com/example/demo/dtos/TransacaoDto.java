package com.example.demo.dtos;

public record TransacaoDto(
    String recebedor,
    String pagador,
    Double quantidade
) {
}
