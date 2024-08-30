package dev.moon.suporteapi.repository;

import dev.moon.suporteapi.model.Cliente;
import dev.moon.suporteapi.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    void deleteByNome(String nome);

    void deleteByTelefone(String telefone);

    List<Optional<Contato>> findByNome(String nome);

    Optional<Contato> findByTelefone(String telefone);

    Optional<List<Contato>> findByEmpresa(Cliente empresa);

    void saveByEmpresa(Cliente empresa);
}
