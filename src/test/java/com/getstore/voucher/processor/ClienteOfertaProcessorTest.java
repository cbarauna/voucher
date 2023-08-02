package com.getstore.voucher.processor;

import com.getstore.voucher.model.TestesModel;
import com.getstore.voucher.services.ClienteOfertaService;
import com.getstore.voucher.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteOfertaProcessorTest {

    @InjectMocks
    ClienteOfertaProcessor processor;
    @Mock
    ClienteOfertaService clienteOfertaService;
    @Mock
    ClienteService clienteService;

    @BeforeEach
    void setUp() {
        processor = new ClienteOfertaProcessor(clienteService, clienteOfertaService);
    }

    @Test
    void criarOfertaCliente() {
        processor = Mockito.mock(ClienteOfertaProcessor.class);
        var oferta = TestesModel.getInstance().oferta();
        Mockito.doNothing().when(processor).criarOfertaCliente(oferta);
        processor.criarOfertaCliente(oferta);
        Mockito.verify(processor, Mockito.times(1))
                .criarOfertaCliente(oferta);

    }
}