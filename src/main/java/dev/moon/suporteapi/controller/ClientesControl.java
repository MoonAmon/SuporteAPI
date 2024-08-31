package dev.moon.suporteapi.controller;

import dev.moon.suporteapi.dto.ClienteUpdateDTO;
import dev.moon.suporteapi.model.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.moon.suporteapi.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@Api(value = "Sistema de gerenciamento de clientes", description = "Operações para gerenciamento de clientes")
public class ClientesControl {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Retorna a lista completa de clientes", response = Cliente.class)
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @ApiOperation(value = "Retorna um cliente pelo ID", response = Cliente.class)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(cliente));
    }

    @ApiOperation(value = "Cria um novo cliente", response = Cliente.class)
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
    Cliente savedCliente = clienteService.save(cliente);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> partialUpdate(@PathVariable Long id, @RequestBody ClienteUpdateDTO clienteUpdateDTO) {
        try {
            Cliente updatedCliente = clienteService.updateCliente(id, clienteUpdateDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCliente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ApiOperation(value = "Deleta um cliente pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Deleta um cliente pelo CNPJ")
    @DeleteMapping("/delete/{cnpj}")
    public ResponseEntity<Void> deleteByCnpj(@PathVariable String cnpj) {
        clienteService.deleteByCnpj(cnpj);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Retorna um cliente pelo CNPJ", response = Cliente.class)
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Optional<Cliente>> findByCnpj(@PathVariable String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(clienteService.findByCnpj(cnpj)));
    }

    @ApiOperation(value = "Salva uma lista de clientes", response = Cliente.class)
    @PostMapping("/saveAll")
    public ResponseEntity<List<Cliente>> saveAll(@RequestBody List<Cliente> clientes) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveAll(clientes));
    }

    @ApiOperation(value = "Retorna uma lista de clientes pelo nome", response = Cliente.class)
    @GetMapping("/nome/like/{nome}")
    public ResponseEntity<Optional<List<Cliente>>> findByNomeFantasiaContainingIgnoreCase(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findByNomeFantasiaContainingIgnoreCase(nome));
    }

}
