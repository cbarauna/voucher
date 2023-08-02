package com.getstore.voucher.mappers;

import com.getstore.voucher.model.ClienteOferta;
import com.getstore.voucher.model.dto.ClienteOfertaDTO;
import com.getstore.voucher.model.dto.ClienteOfertaEmailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ClienteOfertaMapper {

    @Mapping(target = "nomeOferta", source = "oferta.nome")
    @Mapping(target = "desconto", source = "oferta.desconto")
    ClienteOfertaDTO dto(ClienteOferta dto);

    @Mapping(target = "nomeOferta", source = "oferta.nome")
    @Mapping(target = "codigoOferta", source = "oferta.codigo")
    @Mapping(target = "dataValidade", source = "oferta.validade")
    ClienteOfertaEmailDTO clienteOfertaEmail(ClienteOferta source);

}
