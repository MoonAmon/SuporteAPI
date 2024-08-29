package service;

import model.SistemaAtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.SistemaAttRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaAttServiceImpl implements SistemaAttService {

    @Autowired
    private SistemaAttRepository sistemaAttRepository;

    @Override
    public SistemaAtt save(SistemaAtt sistemaAtt) {
        return sistemaAttRepository.save(sistemaAtt);
    }

    @Override
    public Optional<SistemaAtt> findById(Long id) {
        return sistemaAttRepository.findById(id);
    }

    @Override
    public SistemaAtt update(SistemaAtt sistemaAtt) {
        return sistemaAttRepository.save(sistemaAtt);
    }

    @Override
    public void deleteById(Long id) {
        sistemaAttRepository.deleteById(id);
    }

    @Override
    public List<SistemaAtt> findAll() {
        return sistemaAttRepository.findAll();
    }
}
