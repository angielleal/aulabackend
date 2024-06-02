package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.dtos.TransacaoDto;
import com.example.demo.mappers.TransacaoMapper;
import com.example.demo.models.Transacao;



@Service
public class TransacaoService {
    @Autowired
    private TransacaoMapper transacaoMapper;

    @Autowired
    private ClienteService clienteService;

    public TransacaoDto processTransacao(Transacao transacao) {
        ClienteDto recebedorDto = clienteService.getClienteByNome(transacao.getRecebedor());
        ClienteDto pagadorDto = clienteService.getClienteByNome(transacao.getPagador());
        if (recebedorDto != null && pagadorDto != null) {
            Double novoSaldoRecebedor = recebedorDto.saldo() + transacao.getQuantidade();
            recebedorDto = new ClienteDto(recebedorDto.nome(), novoSaldoRecebedor);
            clienteService.updateSaldoCliente(recebedorDto);
    
            Double novoSaldoPagador = pagadorDto.saldo() - transacao.getQuantidade();
            pagadorDto = new ClienteDto(pagadorDto.nome(), novoSaldoPagador);
            clienteService.updateSaldoCliente(pagadorDto);
        }

        return transacaoMapper.toDto(transacao);
    }
}
