package service;

import model.Cliente;

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

}
