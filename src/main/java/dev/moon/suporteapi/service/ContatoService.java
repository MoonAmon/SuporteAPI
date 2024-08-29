package service;

import model.Cliente;
import model.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoService {

    Contato save(Contato contato);

    Contato update(Contato contato);

    void deleteById(Long id);

    void deleteByNome(String nome);

    void deleteByTelefone(String telefone);

    Optional<Contato> findById(Long id);

    List<Optional<Contato>> findByNome(String nome);

    Optional<Contato> findByTelefone(String telefone);

    Optional<List<Contato>> findByEmpresa(Cliente empresa);

    List<Contato> findAll();

}
