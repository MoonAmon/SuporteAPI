package dev.moon.suporteapi.controller;

import dev.moon.suporteapi.model.SistemaAtt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.moon.suporteapi.service.SistemaAttService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sistemas-atts")
public class SistemaAttControl {

    @Autowired
    private SistemaAttService sistemsAttService;

    @GetMapping
    public ResponseEntity<List<SistemaAtt>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sistemsAttService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SistemaAtt>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(sistemsAttService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SistemaAtt> create(@RequestBody SistemaAtt sistemaAtt) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sistemsAttService.save(sistemaAtt));
    }

    @PutMapping
    public ResponseEntity<SistemaAtt> update(@RequestBody SistemaAtt sistemaAtt) {
        return ResponseEntity.status(HttpStatus.OK).body(sistemsAttService.update(sistemaAtt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        sistemsAttService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
