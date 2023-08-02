package com.getstore.voucher.controller;

import com.getstore.voucher.exception.Error;
import com.getstore.voucher.model.dto.ClienteOfertaEmailDTO;
import com.getstore.voucher.model.dto.CriarOfertaDTO;
import com.getstore.voucher.services.OfertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/voucher/oferta")
@RequiredArgsConstructor
@Tag(name = "Voucher", description = "Controller para manipular dados do voucher.")
public class VoucherController {
    private final OfertaService ofertaService;

    @Operation(summary = "Incluir uma oferta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Oferta cadatrada",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteOfertaEmailDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Erro ao incluir oferta",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))})
    })
    @PostMapping("/incluir")
    @ResponseStatus(HttpStatus.CREATED)
    public CriarOfertaDTO gerarVoucher(@RequestBody CriarOfertaDTO criarOferta) {
       return ofertaService.criarOferta(criarOferta);
    }

}
