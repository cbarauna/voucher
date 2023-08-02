package com.getstore.voucher.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cliente {

    private String nome;
    @Id
    private String email;
    private LocalDateTime dataCriacao;
}
