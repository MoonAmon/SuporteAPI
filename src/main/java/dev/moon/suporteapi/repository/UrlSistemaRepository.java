package dev.moon.suporteapi.repository;

import dev.moon.suporteapi.model.Sistema;
import dev.moon.suporteapi.model.UrlSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlSistemaRepository extends JpaRepository<UrlSistema, Long> {
    List<Optional<UrlSistema>> findByCliente(Sistema sistema);

}
