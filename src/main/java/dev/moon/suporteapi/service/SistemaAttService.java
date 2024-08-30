package dev.moon.suporteapi.service;

import dev.moon.suporteapi.model.SistemaAtt;

import java.util.List;
import java.util.Optional;

public interface SistemaAttService {

    SistemaAtt save(SistemaAtt sistemaAtt);

    Optional<SistemaAtt> findById(Long id);

    SistemaAtt update(SistemaAtt sistemaAtt);

    void deleteById(Long id);

    List<SistemaAtt> findAll();

}
