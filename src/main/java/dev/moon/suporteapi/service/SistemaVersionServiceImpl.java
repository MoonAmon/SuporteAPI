package service;

import model.SistemaVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SistemaVersionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaVersionServiceImpl implements SistemaVersionService {

    @Autowired
    private SistemaVersionRepository sistemaVersionRepository;

    @Override
    public SistemaVersion save(SistemaVersion sistemaVersion) {
        return sistemaVersionRepository.save(sistemaVersion);
    }

    @Override
    public List<SistemaVersion> findAll() {
        return sistemaVersionRepository.findAll();
    }

    @Override
    public Optional<SistemaVersion> findById(Long id) {
        return sistemaVersionRepository.findById(id);
    }

    @Override
    public SistemaVersion update(SistemaVersion sistemaVersion) {
        return sistemaVersionRepository.save(sistemaVersion);
    }

    @Override
    public void deleteById(Long id) {
        sistemaVersionRepository.deleteById(id);
    }
}
