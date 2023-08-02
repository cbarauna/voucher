package com.getstore.voucher.repositories;

import com.getstore.voucher.model.ClienteOferta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClienteOfertaRepository extends MongoRepository<ClienteOferta, String> {

    ClienteOferta findByCliente_EmailAndOferta_Codigo(String email, String codigo);

    List<ClienteOferta> findAllByCliente_EmailAndDataUsoIsNull(String email);
}
