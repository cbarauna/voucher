package com.getstore.voucher.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriarOfertaDTO {
    @Schema(description = "Codigo usado para cadastrar a oferta, caso não seja informado a aplicação gera automaticamente")
    public String codigo;

    @Schema(description = "Nome da oferta")
    public String nome;

    @Schema(description = "Valor do desconto da oferta", example = "10", maximum = "99")
    private BigDecimal desconto;

    @Schema(description = "Data de validade da oferta")
    public LocalDate validade;

}
