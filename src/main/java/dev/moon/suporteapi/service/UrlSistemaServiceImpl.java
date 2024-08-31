package dev.moon.suporteapi.service;

import dev.moon.suporteapi.model.Sistema;
import dev.moon.suporteapi.model.UrlSistema;
import dev.moon.suporteapi.repository.UrlSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlSistemaServiceImpl implements UrlSistemaService {

    @Autowired
    private UrlSistemaRepository urlSistemaRepository;

    @Override
    public UrlSistema save(UrlSistema urlSistema) {
        return urlSistemaRepository.save(urlSistema);
    }

    @Override
    public List<UrlSistema> findAll() {
        return urlSistemaRepository.findAll();
    }

    @Override
    public Optional<UrlSistema> findById(Long id) {
        return urlSistemaRepository.findById(id);
    }

    @Override
    public UrlSistema update(UrlSistema urlSistema) {
        return urlSistemaRepository.save(urlSistema);
    }

    @Override
    public void deleteById(Long id) {
        urlSistemaRepository.deleteById(id);
    }

    @Override
    public List<Optional<UrlSistema>> findByCliente(Sistema sistema) {
        return urlSistemaRepository.findByCliente(sistema);
    }

}
