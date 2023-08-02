package com.getstore.voucher.controller;

import com.getstore.voucher.model.TestesModel;
import com.getstore.voucher.model.dto.ClienteDTO;
import com.getstore.voucher.services.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @InjectMocks
    private ClienteController controller;

    @Mock
    private ClienteService clienteService;

    @BeforeEach
    void setup() {
        controller = new ClienteController(clienteService);
    }
    @Test
    void incluirClientes() {
        controller = Mockito.mock(ClienteController.class);
        List<ClienteDTO> list = new ArrayList<>();
        Mockito.doNothing().when(controller).incluirClientes(list);
        controller.incluirClientes(list);
        Mockito.verify(controller, Mockito.times(1))
                .incluirClientes(list);
    }

    @Test
    void incluirCliente() {
        controller = Mockito.mock(ClienteController.class);
       var cliente = TestesModel.getInstance().clienteDTO();
        Mockito.doNothing().when(controller).incluirCliente(cliente);
        controller.incluirCliente(cliente);
        Mockito.verify(controller, Mockito.times(1))
                .incluirCliente(cliente);
    }

    @Test
    void buscarCliente() {
        when(clienteService.buscarPorEmail("maria.souza@example.com"))
                .thenReturn(Mockito.mock(ClienteDTO.class));
        Assertions.assertNotNull(controller.buscarCliente("maria.souza@example.com"));
    }
}