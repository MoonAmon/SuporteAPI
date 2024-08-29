package controller;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClientesControl {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/delete/{cnpj}")
    public ResponseEntity<Void> deleteByCnpj(@PathVariable String cnpj) {
        clienteService.deleteByCnpj(cnpj);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Optional<Cliente>> findByCnpj(@PathVariable String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(clienteService.findByCnpj(cnpj)));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Optional<List<Cliente>>> findByNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findByNome(nome));
    }

}
