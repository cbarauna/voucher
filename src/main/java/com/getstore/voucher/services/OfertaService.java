package com.getstore.voucher.services;

import com.getstore.voucher.mappers.OfertaMapper;
import com.getstore.voucher.model.dto.CriarOfertaDTO;
import com.getstore.voucher.processor.ClienteOfertaProcessor;
import com.getstore.voucher.repositories.OfertaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@AllArgsConstructor
public class OfertaService {

    private final OfertaRepository repository;

    private final OfertaMapper mapper;

    private final ClienteOfertaProcessor clienteOfertaProcessor;

    public CriarOfertaDTO criarOferta(CriarOfertaDTO oferta) {

        if (Objects.nonNull(oferta) && oferta.getDesconto().
                compareTo(BigDecimal.valueOf(100)) >= 0) {
            throw new RuntimeException("Valor do desconto invalido!");
        }
        if (Objects.nonNull(oferta) && Objects.nonNull(oferta.getCodigo())
                && oferta.getCodigo().length() < 8) {
            throw new RuntimeException("Codigo da oferta precisa ter no minimo 8 digitos.");
        }
        var entidade = repository.save(mapper.entidade(oferta));
        clienteOfertaProcessor.criarOfertaCliente(entidade);
        return mapper.dto(entidade);
    }
}
