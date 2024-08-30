package dev.moon.suporteapi.repository;

import dev.moon.suporteapi.model.SistemaVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaVersionRepository extends JpaRepository<SistemaVersion, Long> {
}
