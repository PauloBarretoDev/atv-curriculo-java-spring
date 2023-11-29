package com.project.main.models;

import jakarta.persistence.*;

@Entity
public class CurriculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String competencias;
    private String experiencia;
    private String email;

    public String getCompetencias() {
        return competencias;
    }
    
    public String getEmail() {
        return email;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public Long getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
