package com.getstore.voucher.processor;

import com.getstore.voucher.model.ClienteOferta;
import com.getstore.voucher.model.Oferta;
import com.getstore.voucher.services.ClienteOfertaService;
import com.getstore.voucher.services.ClienteService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class ClienteOfertaProcessor {

    private final ClienteService clienteService;
    private final ClienteOfertaService ofertaService;

    public ClienteOfertaProcessor(ClienteService clienteService, ClienteOfertaService ofertaService) {
        this.clienteService = clienteService;
        this.ofertaService = ofertaService;
    }

    public void criarOfertaCliente(Oferta oferta) {
        var clientes = clienteService.findAllClientes();
        var clienteOfertas = clientes.stream().map(cliente ->
                ClienteOferta.builder()
               .oferta(oferta)
               .cliente(cliente)
               .dataCriacao(LocalDateTime.now())
               .build()).collect(Collectors.toList());
        ofertaService.criarOferta(clienteOfertas);
    }
}
