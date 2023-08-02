package com.getstore.voucher.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteOfertaDTO {
    @Schema(description = "Valor do desconto cadastrado na oferta", example = "10", maximum = "99")
    private BigDecimal desconto;
    @Schema(description = "Nome da oferta")
    private String nomeOferta;


}
