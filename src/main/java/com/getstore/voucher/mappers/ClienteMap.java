package com.getstore.voucher.mappers;

import com.getstore.voucher.model.Cliente;
import com.getstore.voucher.model.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ClienteMap {

    Cliente entidade(ClienteDTO dto);

    ClienteDTO dto(Cliente cliente);
}
