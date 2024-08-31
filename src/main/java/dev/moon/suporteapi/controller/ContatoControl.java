package dev.moon.suporteapi.controller;

import dev.moon.suporteapi.model.Cliente;
import dev.moon.suporteapi.model.Contato;
import dev.moon.suporteapi.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.moon.suporteapi.service.ContatoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
@Api(value = "Sistema de gerenciamento de contatos", description = "Operações para gerenciamento de contatos")
public class ContatoControl {

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Retorna a lista completa de contatos", response = Contato.class)
    @GetMapping
    public ResponseEntity<List<Contato>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findAll());
    }

    @ApiOperation(value = "Cria um novo contato", response = Contato.class)
    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato, @RequestParam Long clienteId) {
        Cliente cliente = clienteService.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        contato.setEmpresa(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.save(contato));
    }

    @ApiOperation(value = "Atualiza um contato existente", response = Contato.class)
    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato) {
        contato.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.update(contato));
    }

    @ApiOperation(value = "Deleta um contato pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contatoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Retorna um contato pelo ID", response = Contato.class)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findById(id));
    }

    @ApiOperation(value = "Deleta um contato pelo nome")
    @DeleteMapping("/delete/{nome}")
    public ResponseEntity<Void> deleteByNome(@PathVariable String nome) {
        contatoService.deleteByNome(nome);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Deleta um contato pelo telefone")
    @DeleteMapping("/delete/{telefone}")
    public ResponseEntity<Void> deleteByTelefone(@PathVariable String telefone) {
        contatoService.deleteByTelefone(telefone);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Retorna um contato pelo telefone", response = Contato.class)
    @GetMapping("/telefone/{telefone}")
    public ResponseEntity<Optional<Contato>> findByTelefone(@PathVariable String telefone) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findByTelefone(telefone));
    }

    @ApiOperation(value = "Retorna uma lista de contatos pelo nome", response = Contato.class)
    @GetMapping("/empresa/{empresa}")
    public ResponseEntity<List<Contato>> findByEmpresa(@PathVariable String nomeEmpresa) {
        Optional<List<Contato>> contatos = Optional.ofNullable(contatoService.findByEmpresa(nomeEmpresa)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada")));
        return ResponseEntity.status(HttpStatus.OK).body(contatos.get());
    }


}
