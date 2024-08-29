package repository;

import model.Cliente;
import model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    void deleteByNome(String nome);

    void deleteByTelefone(String telefone);

    List<Optional<Contato>> findByNome(String nome);

    Optional<Contato> findByTelefone(String telefone);

    Optional<List<Contato>> findByEmpresa(Cliente empresa);
}
