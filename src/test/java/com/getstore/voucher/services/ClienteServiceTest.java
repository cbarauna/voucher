package com.getstore.voucher.services;

import com.getstore.voucher.mappers.ClienteMap;
import com.getstore.voucher.model.Cliente;
import com.getstore.voucher.model.TestesModel;
import com.getstore.voucher.repositories.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository repository;

    @Mock
    private  ClienteMap map;

    @BeforeEach
    void setUp() {
        clienteService = new ClienteService(repository, map);
    }

    @Test
    void incluir() {
        var list = TestesModel.getInstance().clienteDTOS();
        var dto = TestesModel.getInstance().clienteDTO();
        when(map.entidade(dto)).thenReturn(Mockito.mock(Cliente.class));
        clienteService.incluir(list);
    }

    @Test
    void buscarPorEmail() {
        var email  = "mariana.almeida@example.com";
        var cliente = TestesModel.getInstance().cliente();
        when(map.dto(cliente)).thenReturn(TestesModel.getInstance().clienteDTO());
        when(repository.findByEmail(email)).thenReturn(cliente);
        var teste = clienteService.buscarPorEmail(email);
        Assertions.assertEquals(teste
                .getEmail(), email);
    }

    @Test
    void findAllClientes() {
        var clientes = TestesModel.getInstance().clientes();
        when(repository.findAll()).thenReturn(clientes);
        Assertions.assertNotNull(clienteService.findAllClientes());

    }
}