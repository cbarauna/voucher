package com.getstore.voucher.repositories;

import com.getstore.voucher.model.Oferta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfertaRepository extends MongoRepository<Oferta, String> {

}
