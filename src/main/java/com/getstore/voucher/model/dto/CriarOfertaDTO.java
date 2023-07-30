package com.getstore.voucher.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriarOfertaDTO {
    public String codigo;
    public String nome;
    private BigDecimal desconto;
    public LocalDate validade;

}
