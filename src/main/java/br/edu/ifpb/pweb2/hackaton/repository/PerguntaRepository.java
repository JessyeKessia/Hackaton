package br.edu.ifpb.pweb2.hackaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.hackaton.model.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {
    
}
