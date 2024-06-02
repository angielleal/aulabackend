package com.example.exercicio09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.exercicio09.dto.ProdutoRequestDTO;
import com.example.exercicio09.dto.ProdutoResponseDTO;
import com.example.exercicio09.model.Produto;
import com.example.exercicio09.exception.ResourceNotFoundException;
import com.example.exercicio09.mapper.ProdutoMapper;
import com.example.exercicio09.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    public ProdutoResponseDTO createProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoMapper.toEntity(produtoRequestDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.toDto(produto);
    }

    public ProdutoResponseDTO getProdutoById(Long id) {
        Optional<com.example.exercicio09.model.Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produtoMapper.toDto(produto.get());
        }
        throw new ResourceNotFoundException("Produto não encontrado com o ID: " + id);
    }

    public List<ProdutoResponseDTO> getAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtoMapper.toDtoList(produtos);
    }

    public ProdutoResponseDTO updateProduto(Long id, ProdutoRequestDTO produtoRequestDTO) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNome(produtoRequestDTO.getNome());
            produto.setPreco(produtoRequestDTO.getPreco());
            produto = produtoRepository.save(produto);
            return produtoMapper.toDto(produto);
        }
        throw new ResourceNotFoundException("Produto não encontrado com o ID: " + id);
    }

    public void deleteProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Produto não encontrado com o ID: " + id);
        }
    }

    public List<ProdutoResponseDTO> findByNome(String nome) {
        List<Produto> produtos = produtoRepository.findByNome(nome);
        return produtoMapper.toDtoList(produtos);
    }
}
