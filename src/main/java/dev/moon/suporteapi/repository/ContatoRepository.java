package dev.moon.suporteapi.repository;

import dev.moon.suporteapi.model.Cliente;
import dev.moon.suporteapi.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    void deleteByNome(String nome);
    void deleteByTelefone(String telefone);

    @Query("SELECT c FROM Contato c WHERE LOWER(c.nome) LIKE LOWER(CONCAT( '%', :nome, '%'))")
    Optional<List<Contato>> findByNomeContainingIgnoreCase(@Param("nome") String nome);

    Optional<Contato> findByTelefone(String telefone);

    @Query("SELECT c FROM Contato c WHERE LOWER(c.empresa.nomeFantasia) LIKE LOWER(CONCAT( '%', :empresa, '%'))")
    Optional<List<Contato>> findByEmpresa(String empresa);

}
