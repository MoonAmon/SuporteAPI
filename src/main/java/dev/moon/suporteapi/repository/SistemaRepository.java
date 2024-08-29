package repository;

import model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SistemaRepository extends JpaRepository<Sistema, Long> {
    List<Optional<Sistema>> findByNome(String nome);
}
