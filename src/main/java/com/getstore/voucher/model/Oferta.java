package com.getstore.voucher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("oferta_especial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Oferta {
    private String nome;
    private BigDecimal desconto;
    @Id
    private String codigo;
    private LocalDate validade;
    private LocalDateTime dataCriacao;
}
