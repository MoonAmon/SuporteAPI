package controller;

import model.SistemaVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SistemaVersionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sistemas-versions")
public class SistemaVersionControl {

    @Autowired
    private SistemaVersionService sistemaVersionService;

    @GetMapping
    public ResponseEntity<List<SistemaVersion>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sistemaVersionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SistemaVersion>> findById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(sistemaVersionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SistemaVersion> create(SistemaVersion sistemaVersion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sistemaVersionService.save(sistemaVersion));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        sistemaVersionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
