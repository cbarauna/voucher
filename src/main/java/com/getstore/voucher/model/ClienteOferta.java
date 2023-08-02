package com.getstore.voucher.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Document("cliente_oferta")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteOferta {
    @Id
    private String id;
    private Cliente cliente;
    private Oferta oferta;
    private LocalDate dataUso;
    private LocalDateTime dataCriacao;

}
