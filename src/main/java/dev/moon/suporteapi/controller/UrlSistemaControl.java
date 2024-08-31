package dev.moon.suporteapi.controller;

import dev.moon.suporteapi.model.UrlSistema;
import dev.moon.suporteapi.repository.UrlSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class UrlSistemaControl {

    @Autowired
    private UrlSistemaRepository urlSistemaRepository;

    @GetMapping
    public ResponseEntity<List<UrlSistema>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(urlSistemaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<UrlSistema> create(UrlSistema urlSistema) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urlSistemaRepository.save(urlSistema));
    }
}
