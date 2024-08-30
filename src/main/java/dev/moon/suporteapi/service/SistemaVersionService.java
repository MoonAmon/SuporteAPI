package dev.moon.suporteapi.service;

import dev.moon.suporteapi.model.SistemaVersion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SistemaVersionService {

    SistemaVersion save(SistemaVersion sistemaVersion);

    List<SistemaVersion> findAll();

    Optional<SistemaVersion> findById(Long id);

    SistemaVersion update(SistemaVersion sistemaVersion);

    void deleteById(Long id);
}
