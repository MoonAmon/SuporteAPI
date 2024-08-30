package dev.moon.suporteapi.repository;

import dev.moon.suporteapi.model.SistemaAtt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaAttRepository extends JpaRepository<SistemaAtt, Long> {
}
