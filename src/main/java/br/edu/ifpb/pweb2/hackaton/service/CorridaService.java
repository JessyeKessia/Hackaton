package br.edu.ifpb.pweb2.hackaton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.ifpb.pweb2.hackaton.model.Corrida;
import br.edu.ifpb.pweb2.hackaton.repository.CorridaRepository;

@Component
public class CorridaService implements Service<Corrida, Long> {

    @Autowired
    CorridaRepository corridaRepository;

    @Override
    public List<Corrida> findAll() {
        return corridaRepository.findAll();
    }

    @Override
    public Corrida findById(Long id) {
        return corridaRepository.findById(id).orElse(null);
    }

    @Override
    public Corrida save(Corrida t) {
        return corridaRepository.save(t);
    }
    
}