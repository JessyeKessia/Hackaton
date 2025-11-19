package br.edu.ifpb.pweb2.hackaton.model;

import java.io.Serializable;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pergunta implements Serializable{
    private static final long Serializable = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String enunciado;
    private String alternativas;
    private String respostaCorreta;

    @ManyToOne
    @JoinColumn(name = "id_corrida")
    @lombok.ToString.Exclude
    @lombok.EqualsAndHashCode.Exclude
    private Corrida corrida;

}
