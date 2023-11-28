package com.project.main.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Getter @Setter @NoArgsConstructor
public class CurriculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String competencias;
    private String experiencia;
    private String email;

    public CurriculoModel(String nome, int idade, String competencias, String experiencia, String email){
        this.nome = nome;
        this.idade = idade;
        this.competencias = competencias;
        this.experiencia = experiencia;
        this.email = email;
    }

}
