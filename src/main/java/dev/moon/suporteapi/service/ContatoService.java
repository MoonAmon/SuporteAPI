package dev.moon.suporteapi.service;

import dev.moon.suporteapi.model.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoService {

    Contato save(Contato contato);

    Contato update(Contato contato);

    void deleteById(Long id);

    void deleteByNome(String nome);

    void deleteByTelefone(String telefone);

    Optional<Contato> findById(Long id);

    Optional<Contato> findByTelefone(String telefone);

    Optional<List<Contato>> findByEmpresa(String empresa);

    Optional<List<Contato>> findByNomeContainingIgnoreCase(String nome);

    List<Contato> findAll();

}
