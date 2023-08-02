package com.getstore.voucher.mappers;

import com.getstore.voucher.model.Oferta;
import com.getstore.voucher.model.dto.CriarOfertaDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OfertaMapper {

    Oferta entidade(CriarOfertaDTO dto);

    CriarOfertaDTO dto(Oferta save);
}
