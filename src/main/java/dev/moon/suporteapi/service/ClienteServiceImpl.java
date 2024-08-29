package service;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void deleteByCnpj(String cnpj) {
        clienteRepository.deleteByCnpj(cnpj);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente findByCnpj(String cnpj) {
        return clienteRepository.findByCnpj(cnpj);
    }

    @Override
    public Optional<List<Cliente>> findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
