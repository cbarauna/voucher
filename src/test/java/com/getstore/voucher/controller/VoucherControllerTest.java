package com.getstore.voucher.controller;

import com.getstore.voucher.model.TestesModel;
import com.getstore.voucher.services.OfertaService;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VoucherControllerTest {

    @InjectMocks
    private VoucherController controller;

    @Mock
    private OfertaService ofertaService;

    @BeforeEach
    void init() {
        controller = new VoucherController(ofertaService);
    }


    @Test
    void gerarVoucher() {
        var criarOferta = TestesModel.getInstance().criarOferta();
        when(ofertaService.criarOferta(criarOferta)).thenReturn(criarOferta);
        var oferta  = controller.gerarVoucher(criarOferta);
        Assertions.assertEquals(oferta.getNome(), "Oferta Teste");
    }
}