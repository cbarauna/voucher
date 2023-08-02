package com.getstore.voucher.services;

import com.getstore.voucher.mappers.OfertaMapper;
import com.getstore.voucher.model.TestesModel;
import com.getstore.voucher.processor.ClienteOfertaProcessor;
import com.getstore.voucher.repositories.OfertaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class OfertaServiceTest {

    @InjectMocks
    private OfertaService ofertaService;

    @Mock
    private  OfertaRepository repository;
    @Mock
    private  OfertaMapper mapper;
    @Mock
    private  ClienteOfertaProcessor clienteOfertaProcessor;

    @BeforeEach
    void setUp() {
        ofertaService = new OfertaService(repository, mapper,
                clienteOfertaProcessor);
    }

    @Test
    void criarOferta() {
        var oferta  = TestesModel.getInstance().criarOfertaDTO();
        Assertions.assertNull(ofertaService.criarOferta(oferta));
    }

    @Test
    void criarOfertaEx() {
        var oferta  = TestesModel.getInstance().criarOfertaDTO();
        oferta.setDesconto(BigDecimal.valueOf(100));
        Assertions.assertThrows(RuntimeException.class, () ->
                ofertaService.criarOferta(oferta));
    }

    @Test
    void criarOfertaExCodigo() {
        var oferta  = TestesModel.getInstance().criarOfertaDTO();
        oferta.setCodigo("codigo");
        Assertions.assertThrows(RuntimeException.class, () ->
                ofertaService.criarOferta(oferta));
    }
}