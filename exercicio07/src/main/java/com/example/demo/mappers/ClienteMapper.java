package com.example.demo.mappers;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.models.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteDto toDto(Cliente Cliente) {
        ClienteDto ClienteDto = new ClienteDto(
            Cliente.getNome(),
            Cliente.getSaldo()
        );
        return ClienteDto;
    }
}
