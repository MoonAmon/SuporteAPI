package repository;

import model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    void deleteByCnpj(String cnpj);

    Cliente findByCnpj(String cnpj);

    Optional<List<Cliente>> findByNome(String nome);

}
