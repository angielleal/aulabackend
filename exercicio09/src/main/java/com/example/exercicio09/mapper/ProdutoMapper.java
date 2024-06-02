package com.example.exercicio09.mapper;

import org.mapstruct.Mapper;
import java.util.List;

import com.example.exercicio09.dto.ProdutoRequestDTO;
import com.example.exercicio09.dto.ProdutoResponseDTO;
import com.example.exercicio09.model.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    Produto toEntity(ProdutoRequestDTO produtoRequestDTO);
    ProdutoResponseDTO toDto(Produto produto);
    List<ProdutoResponseDTO> toDtoList(List<Produto> produtos);
}
