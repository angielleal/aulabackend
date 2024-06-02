package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.example.demo.dtos.ClienteDto;
import com.example.demo.services.ClienteService;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;


    @GetMapping("/cliente/{nome}")
    public ResponseEntity<Object> getClienteByNome(@PathVariable String nome) {
        ClienteDto clienteDto = clienteService.getClienteByNome(nome);
        if (clienteDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(clienteDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }
}
