package com.getstore.voucher.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteOfertaEmailDTO {

    private String codigoOferta;

    private String nomeOferta;

    private LocalDate dataValidade;
}
