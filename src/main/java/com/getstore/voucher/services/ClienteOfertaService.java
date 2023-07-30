package com.getstore.voucher.services;

import com.getstore.voucher.mappers.ClienteOfertaMapper;
import com.getstore.voucher.model.ClienteOferta;
import com.getstore.voucher.model.dto.ClienteOfertaDTO;
import com.getstore.voucher.model.dto.ClienteOfertaEmailDTO;
import com.getstore.voucher.repositories.ClienteOfertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteOfertaService {

    private final ClienteOfertaRepository repository;

    private final ClienteOfertaMapper mapper;

    public void criarOferta(List<ClienteOferta> ofertas) {
        repository.saveAll(ofertas);
    }

    public ClienteOfertaDTO validarOferta(String email, String codigo) {

        ClienteOferta clienteOferta = repository.findByCliente_EmailAndOferta_Codigo(email, codigo);

        return Optional.ofNullable(clienteOferta).map(oferta -> {
            if (Objects.nonNull(oferta.getDataUso())) {
                throw new RuntimeException("Voucher já utilizado!");
            }
            atualizarOfertaCliente(oferta);
            return mapper.dto(oferta);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Voucher Não encontrado para os dados informados"));

    }

    public void atualizarOfertaCliente(ClienteOferta clienteOferta) {
        clienteOferta.setDataUso(LocalDate.now());
        repository.save(clienteOferta);
    }

    public List<ClienteOfertaEmailDTO> buscarOfertaPorEmail(String email) {

        List<ClienteOferta> ofertas = repository.findAllByCliente_EmailAndDataUsoIsNull(email);
        if (ofertas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Nenhum Voucher encontrado para os dados informados");
        }

        return ofertas.stream().map(mapper::clienteOfertaEmail)
                .collect(Collectors.toList());

    }
}
