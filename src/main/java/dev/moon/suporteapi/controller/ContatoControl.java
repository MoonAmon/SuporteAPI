package dev.moon.suporteapi.controller;

import dev.moon.suporteapi.model.Cliente;
import dev.moon.suporteapi.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.moon.suporteapi.service.ContatoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
public class ContatoControl {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Contato> create(Contato contato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contato));
    }

    @PutMapping
    public ResponseEntity<Contato> update(Contato contato) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.update(contato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contatoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findById(id));
    }

    @DeleteMapping("/delete/{nome}")
    public ResponseEntity<Void> deleteByNome(@PathVariable String nome) {
        contatoService.deleteByNome(nome);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/delete/{telefone}")
    public ResponseEntity<Void> deleteByTelefone(@PathVariable String telefone) {
        contatoService.deleteByTelefone(telefone);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Optional<Contato>> findByNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable((Contato) contatoService.findByNome(nome)));
    }

    @GetMapping("/telefone/{telefone}")
    public ResponseEntity<Optional<Contato>> findByTelefone(@PathVariable String telefone) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findByTelefone(telefone));
    }

    @GetMapping("/empresa/{empresa}")
    public ResponseEntity<Optional<Optional<List<Contato>>>> findByEmpresa(@PathVariable Cliente empresa) {
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(contatoService.findByEmpresa(empresa)));
    }


}
