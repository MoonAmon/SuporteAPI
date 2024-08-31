package dev.moon.suporteapi.service;

import dev.moon.suporteapi.model.Sistema;
import dev.moon.suporteapi.model.UrlSistema;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UrlSistemaService {
    UrlSistema save(UrlSistema urlSistema);
    List<UrlSistema> findAll();
    Optional<UrlSistema> findById(Long id);
    UrlSistema update(UrlSistema urlSistema);
    void deleteById(Long id);
    List<Optional<UrlSistema>> findByCliente(Sistema sistema);
}
