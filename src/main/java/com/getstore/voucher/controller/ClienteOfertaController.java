package com.getstore.voucher.controller;

import com.getstore.voucher.exception.Error;
import com.getstore.voucher.model.dto.ClienteOfertaDTO;
import com.getstore.voucher.model.dto.ClienteOfertaEmailDTO;
import com.getstore.voucher.services.ClienteOfertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/voucher")
@Tag(name = " Cliente Oferta", description = "Controller para manipular dados das ofertas vinculadas a um cliente.")
@RequiredArgsConstructor
public class ClienteOfertaController {

    private final ClienteOfertaService clienteOfertaService;

    @GetMapping("/validar")
    @Operation(summary = "Validar Vaucher")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Voucher validado e atualizado data e hora de uso",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteOfertaDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Erro ao validar Voucher e ou Voucher já utilizado",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))})
    })
    public ResponseEntity<ClienteOfertaDTO> validarOferta(@Param("email")String email,
                                                          @Param("codigo") String codigo) {
       return ResponseEntity.ok().body(clienteOfertaService.validarOferta(email, codigo));
    }
    @Operation(summary = "Busar Voucher Validos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Voucher validos e não utilizados encontrados",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClienteOfertaEmailDTO.class)))}),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar voucher",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))})
    })
    @GetMapping("/{email}")
    public ResponseEntity<List<ClienteOfertaEmailDTO>> buscarOfertasPorEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(clienteOfertaService.buscarOfertaPorEmail(email));
    }
}
