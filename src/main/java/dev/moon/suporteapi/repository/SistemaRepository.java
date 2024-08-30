package dev.moon.suporteapi.repository;

import dev.moon.suporteapi.model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Long> {
    List<Optional<Sistema>> findByNome(String nome);
}
