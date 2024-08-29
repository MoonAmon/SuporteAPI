package service;

import model.SistemaVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SistemaVersionRepository;

import java.util.List;
import java.util.Optional;

@Service
public interface SistemaVersionService {

    SistemaVersion save(SistemaVersion sistemaVersion);

    List<SistemaVersion> findAll();

    Optional<SistemaVersion> findById(Long id);

    SistemaVersion update(SistemaVersion sistemaVersion);

    void deleteById(Long id);
}
