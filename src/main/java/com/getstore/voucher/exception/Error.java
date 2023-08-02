package com.getstore.voucher.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Error {
    private LocalDateTime data;
    private Integer estatus;
    private String erro;
    private String messagem;
}
