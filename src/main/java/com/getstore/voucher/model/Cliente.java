package com.getstore.voucher.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    private String nome;
    @Id
    private String email;
    private LocalDateTime dataCriacao;
}
