package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import com.example.demo.dtos.TransacaoDto;
import com.example.demo.models.Transacao;
import com.example.demo.services.TransacaoService;

import jakarta.validation.Valid;

@RestController
@Validated
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<Object> realizarTransacao(@RequestBody @Valid Transacao transacao) {
        TransacaoDto transacaoDto = transacaoService.processTransacao(transacao);
        return ResponseEntity.status(HttpStatus.OK).body(transacaoDto);
    }
}
