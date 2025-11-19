package br.edu.ifpb.pweb2.hackaton.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.hackaton.model.Pergunta;
import br.edu.ifpb.pweb2.hackaton.repository.PerguntaRepository;

@Component
public class PerguntaService implements Service<Pergunta, Integer> {
    
    @Autowired
    private PerguntaRepository perguntaRepository;

    @Override
    public java.util.List<Pergunta> findAll() {
        return perguntaRepository.findAll();
    }
    @Override
    public Pergunta findById(Integer id) {
        return perguntaRepository.findById(id).orElse(null);
    }

    @Override
    public Pergunta save(Pergunta t) {
        return perguntaRepository.save(t);
    }




}
