package com.getstore.voucher.controller;

import com.getstore.voucher.exception.Error;
import com.getstore.voucher.model.dto.ClienteDTO;
import com.getstore.voucher.model.dto.ClienteOfertaEmailDTO;
import com.getstore.voucher.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/cliente")
@Tag(name = "Cliente", description = "Controller para manipular dados dos clientes.")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @Operation(summary = "Popular Clientes, EndPoint usado para popular dados dos clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Clientes inseridos com sucesso",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(
                            schema = @Schema(implementation = ClienteOfertaEmailDTO.class)))}),
            @ApiResponse(responseCode = "500", description = "Erro ao incluir clientes",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))})
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void incluirCliente(@RequestBody List<ClienteDTO> cliente) {
        clienteService.incluir(cliente);
    }

    @Operation(summary = "Buscar Clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(
                            schema = @Schema(implementation = ClienteOfertaEmailDTO.class)))}),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar cliente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseEntity<ClienteDTO> buscarCliente(@Param("email") String email){
       return ResponseEntity.ok().body(clienteService.buscarPorEmail(email));
    }
}