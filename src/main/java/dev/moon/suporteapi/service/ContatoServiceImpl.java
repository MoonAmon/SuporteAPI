package service;

import model.Cliente;
import model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ContatoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Contato update(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public void deleteById(Long id) {
        contatoRepository.deleteById(id);
    }

    @Override
    public void deleteByNome(String nome) {
        contatoRepository.deleteByNome(nome);
    }

    @Override
    public void deleteByTelefone(String telefone) {
        contatoRepository.deleteByTelefone(telefone);
    }

    @Override
    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public List<Optional<Contato>> findByNome(String nome) {
        return contatoRepository.findByNome(nome);
    }

    @Override
    public Optional<Contato> findByTelefone(String telefone) {
        return contatoRepository.findByTelefone(telefone);
    }

    @Override
    public Optional<List<Contato>> findByEmpresa(Cliente empresa) {
        return contatoRepository.findByEmpresa(empresa);
    }

    @Override
    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }
}
