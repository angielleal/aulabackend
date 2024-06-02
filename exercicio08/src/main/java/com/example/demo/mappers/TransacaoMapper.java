package com.example.demo.mappers;

import com.example.demo.dtos.TransacaoDto;
import com.example.demo.models.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {
    public TransacaoDto toDto(Transacao transacao) {
        TransacaoDto transacaoDto = new TransacaoDto(
            transacao.getRecebedor(),
            transacao.getPagador(),
            transacao.getQuantidade()
        );
        return transacaoDto;
    }
}
