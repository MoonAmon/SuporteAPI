package service;

import model.Sistema;

import java.util.List;
import java.util.Optional;

public interface SistemaService {

    Sistema save(Sistema sistema);

    Optional<Sistema> findById(Long id);

    Sistema update(Sistema sistema);

    List<Optional<Sistema>> findByNome(String nome);

    void deleteById(Long id);
}

