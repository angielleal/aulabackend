package com.example.exercicio09.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.exercicio09.dto.ProdutoRequestDTO;
import com.example.exercicio09.dto.ProdutoResponseDTO;
import com.example.exercicio09.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        ProdutoResponseDTO createdProduto = produtoService.createProduto(produtoRequestDTO);
        return ResponseEntity.ok(createdProduto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoById(@PathVariable Long id) {
        ProdutoResponseDTO produto = produtoService.getProdutoById(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getAllProdutos() {
        List<ProdutoResponseDTO> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        ProdutoResponseDTO updatedProduto = produtoService.updateProduto(id, produtoRequestDTO);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProdutoResponseDTO>> findByNome(@RequestParam String nome) {
        List<ProdutoResponseDTO> produtos = produtoService.findByNome(nome);
        return ResponseEntity.ok(produtos);
    }
}
