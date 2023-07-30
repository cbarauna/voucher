package com.getstore.voucher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("cliente_oferta")@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteOferta {
    @Id
    private String id;
    private Cliente cliente;
    private Oferta oferta;
    private LocalDate dataUso;

    private LocalDateTime dataCriacao;
}
