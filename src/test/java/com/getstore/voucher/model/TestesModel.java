package com.getstore.voucher.model;

import com.getstore.voucher.model.dto.CriarOfertaDTO;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
public class TestesModel {


    @Getter
    private static final TestesModel instance = new TestesModel();


    public CriarOfertaDTO criarOferta(){

        return CriarOfertaDTO.builder()
                .codigo(UUID.randomUUID().toString())
                .desconto(BigDecimal.ONE)
                .nome("Oferta Teste")
                .validade(LocalDate.now())
                .build();
    }
}
