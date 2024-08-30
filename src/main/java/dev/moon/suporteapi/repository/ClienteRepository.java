package dev.moon.suporteapi.repository;

import dev.moon.suporteapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    void deleteByCnpj(String cnpj);
    Cliente findByCnpj(String cnpj);
    Optional<List<Cliente>> findByNomeFantasia(String nome);

    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nomeFantasia) LIKE LOWER(CONCAT( '%', :nome, '%'))")
    Optional<List<Cliente>> findByNomeFantasiaContainingIgnoreCase(@Param("nome") String nome);

}
