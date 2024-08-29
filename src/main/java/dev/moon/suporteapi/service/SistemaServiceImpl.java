package service;

import model.Sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SistemaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaServiceImpl implements SistemaService {

    @Autowired
    private SistemaRepository sistemaRepository;

    @Override
    public Sistema save(Sistema sistema) {
        return sistemaRepository.save(sistema);
    }

    @Override
    public Optional<Sistema> findById(Long id) {
        return sistemaRepository.findById(id);
    }

    @Override
    public Sistema update(Sistema sistema) {
        return sistemaRepository.save(sistema);
    }

    @Override
    public List<Optional<Sistema>> findByNome(String nome) {
        return sistemaRepository.findByNome(nome);
    }

    @Override
    public void deleteById(Long id) {
        sistemaRepository.deleteById(id);
    }
}
