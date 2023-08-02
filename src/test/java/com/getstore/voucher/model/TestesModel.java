package com.getstore.voucher.model;

import com.getstore.voucher.model.dto.ClienteDTO;
import com.getstore.voucher.model.dto.ClienteOfertaDTO;
import com.getstore.voucher.model.dto.CriarOfertaDTO;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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

    public ClienteOfertaDTO clienteOfertaDTO() {
        return ClienteOfertaDTO.builder()
                .nomeOferta("Oferta Teste")
                .desconto(BigDecimal.ONE)
                .build();
    }

    public List<ClienteOfertaDTO> clienteOfertaDTOS() {
        return Collections.singletonList(clienteOfertaDTO());
    }

    public Oferta oferta() {
        return Oferta.builder()
                .dataCriacao(LocalDateTime.now())
                .codigo(UUID.randomUUID().toString())
                .desconto(BigDecimal.TEN)
                .nome("Oferta teste")
                .validade(LocalDate.now().plusMonths(1))
                .build();
    }

    public Cliente cliente() {
        return Cliente.builder()
                .dataCriacao(LocalDateTime.now())
                .email("mariana.almeida@example.com")
                .nome("Cliente Teste")
                .build();
    }

    public List<Cliente> clientes(){
        return Collections.singletonList(cliente());
    }

    public ClienteDTO clienteDTO() {
        return ClienteDTO.builder()
                .email("mariana.almeida@example.com")
                .nome("Mariana Almeida")
                .build();
    }

    public List<ClienteDTO> clienteDTOS() {
        return Collections.singletonList(clienteDTO());
    }

    public CriarOfertaDTO criarOfertaDTO() {
        return CriarOfertaDTO.builder()
                .codigo(UUID.randomUUID().toString())
                .desconto(BigDecimal.TEN)
                .nome("Criar Oferta")
                .validade(LocalDate.now())
                .build();
    }

    public ClienteOferta clienteOferta() {
        return ClienteOferta.builder()
                .cliente(cliente())
                .oferta(oferta())
                .id(UUID.randomUUID().toString())
                .build();
    }

    public List<ClienteOferta> clienteOfertas() {
        return Collections.singletonList(clienteOferta());
    }

}
