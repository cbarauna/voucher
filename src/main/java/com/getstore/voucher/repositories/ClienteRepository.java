package com.getstore.voucher.repositories;

import com.getstore.voucher.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    Cliente findByEmail(String email);
}
