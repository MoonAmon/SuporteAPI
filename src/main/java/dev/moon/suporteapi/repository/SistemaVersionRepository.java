package repository;

import model.SistemaVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SistemaVersionRepository extends JpaRepository<SistemaVersion, Long> {
}
