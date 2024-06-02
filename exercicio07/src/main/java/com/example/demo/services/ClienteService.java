package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.dtos.ClienteDto;
import com.example.demo.mappers.ClienteMapper;
import com.example.demo.models.Cliente;
import java.util.HashMap;
import java.util.Map;


@Service
public class ClienteService {
    private Map<String, Cliente> clienteMap = new HashMap<>();

    @Autowired
    private ClienteMapper clienteMapper;


    public ClienteService() {
        Cliente cliente1 = new Cliente("João", 1000.00, "123");
        Cliente cliente2 = new Cliente("Pedro", 2000.00, "456");
        Cliente cliente3 = new Cliente("Darabas", 3000.00, "789");

        clienteMap.put(cliente1.getNome(), cliente1);
        clienteMap.put(cliente2.getNome(), cliente2);
        clienteMap.put(cliente3.getNome(), cliente3);
    }

    public ClienteDto getClienteByNome(String nome) {
        Cliente cliente = clienteMap.get(nome);
        if (cliente != null) {
            return clienteMapper.toDto(cliente);
        }
        return null;
    }

    public void updateSaldoCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteMap.get(clienteDto.nome());
        if (cliente != null) {
            cliente.setSaldo(clienteDto.saldo());
        }
    }
}
