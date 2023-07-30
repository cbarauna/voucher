package com.getstore.voucher.services;

import com.getstore.voucher.mappers.ClienteMap;
import com.getstore.voucher.model.Cliente;
import com.getstore.voucher.model.dto.ClienteDTO;
import com.getstore.voucher.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    private final ClienteMap map;

    public void incluir(List<ClienteDTO> clientes) {
        if(clientes.isEmpty())
            return;
        try {
            var list = clientes.stream().map(cliente ->{
                Cliente cli = map.entidade(cliente);
                cli.setDataCriacao(LocalDateTime.now());
                    return cli;
            })
                    .collect(Collectors.toList());
            var t =  repository.saveAll(list);
            System.out.println(t);
        } catch (DuplicateKeyException exception) {
            throw new RuntimeException(String.format("Erro ao incluir cliente - ERRO: %s",
                    exception.getMessage()));
        }

    }

    public ClienteDTO  buscarPorEmail(String email) {
        Cliente cliente = repository.findByEmail(email);
        return map.dto(cliente);
    }

    public List<Cliente> findAllClientes() {

        return repository.findAll();
    }
}
