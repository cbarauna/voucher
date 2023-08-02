package com.getstore.voucher.controller;

import com.getstore.voucher.model.TestesModel;
import com.getstore.voucher.services.ClienteOfertaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteOfertaControllerTest {

    @InjectMocks
    private ClienteOfertaController controller;

    @Mock
    private ClienteOfertaService clienteOfertaService;

    @Test
    void validarOferta() {
        var uid = UUID.randomUUID();
        var clienteOfertaDTO = TestesModel.getInstance().clienteOfertaDTO();
        when(clienteOfertaService.validarOferta("joao.silva@example.com", uid.toString()))
                .thenReturn(clienteOfertaDTO);
        var teste = controller.validarOferta("joao.silva@example.com", uid.toString());
        Assertions.assertEquals(teste.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void validarOfertaEx() {
        var uid = UUID.randomUUID();
        when(clienteOfertaService.validarOferta("joao.silva@example.com", uid.toString()))
                .thenThrow(ResponseStatusException.class);
        Assertions.assertThrows(ResponseStatusException.class, () ->
                controller.validarOferta("joao.silva@example.com", uid.toString()));
    }

    @Test
    void buscarOfertasPorEmail() {

      Assertions.assertNotNull(
              controller.buscarOfertasPorEmail("joao.silva@example.com"));
    }

    @Test
    void buscarOfertasEmailEx() {
        when(controller.buscarOfertasPorEmail("joao.silva@example.com")).thenThrow(
                ResponseStatusException.class);
        Assertions.assertThrows(ResponseStatusException.class, () ->
                controller.buscarOfertasPorEmail("joao.silva@example.com"));
    }
}