package com.project.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.main.models.CurriculoModel;

public interface CurriculoRepository extends JpaRepository<CurriculoModel, Long> {
    
}
