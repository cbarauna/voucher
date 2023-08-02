package com.getstore.voucher.services;

import com.getstore.voucher.mappers.ClienteOfertaMapper;
import com.getstore.voucher.model.TestesModel;
import com.getstore.voucher.repositories.ClienteOfertaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteOfertaServiceTest {

    @InjectMocks
    private ClienteOfertaService clienteOfertaService;

    @Mock
    private ClienteOfertaRepository repository;

    @Mock
    private ClienteOfertaMapper mapper;

    @BeforeEach
    void setUp() {
        clienteOfertaService = new ClienteOfertaService(repository, mapper);
    }

    @Test
    void criarOferta() {
    }

    @Test
    void validarOferta() {
    }

    @Test
    void atualizarOfertaCliente() {
    }

    @Test
    void buscarOfertaPorEmail() {
        var email = "fernando.gomes@example.com";
        var clienteOfertas = TestesModel.getInstance().clienteOfertas();
        when(repository.findAllByCliente_EmailAndDataUsoIsNull(email))
                .thenReturn(clienteOfertas);
        Assertions.assertNotNull(clienteOfertaService.buscarOfertaPorEmail(email));
    }

    @Test
    void buscarOfertaPorEmailEx() {
        var email = "fernando.gomes@example.com";
        Assertions.assertThrows(ResponseStatusException.class,
                () -> clienteOfertaService.buscarOfertaPorEmail(email));
    }
}