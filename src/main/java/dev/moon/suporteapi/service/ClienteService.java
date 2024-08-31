package dev.moon.suporteapi.service;

import dev.moon.suporteapi.dto.ClienteUpdateDTO;
import dev.moon.suporteapi.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente save(Cliente cliente);

    Cliente update(Cliente cliente);

    void deleteById(Long id);

    void deleteByCnpj(String cnpj);

    Optional<Cliente> findById(Long id);

    Cliente findByCnpj(String cnpj);

    Optional<List<Cliente>> findByNome(String nome);

    List<Cliente> findAll();

    List<Cliente> saveAll(List<Cliente> clientes);

    Optional<List<Cliente>> findByNomeFantasiaContainingIgnoreCase(String nome);

    Cliente updateCliente(Long id, ClienteUpdateDTO clienteUpdateDTO);
}
