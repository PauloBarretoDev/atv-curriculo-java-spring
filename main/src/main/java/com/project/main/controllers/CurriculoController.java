package com.project.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.main.models.CurriculoModel;
import com.project.main.repositories.CurriculoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculos")
@CrossOrigin
public class CurriculoController {

    @Autowired
    CurriculoRepository repository;

    @GetMapping(value = "/listar")
    public List<CurriculoModel> listarCurriculos()  {
        return repository.findAll();
    }

    @GetMapping("/curriculo/{id}")
    public Optional<CurriculoModel> getCurriculoById(@PathVariable Long id){
        return repository.findById(id);
    }            

    @PostMapping("/criar")
    CurriculoModel newPiloto(@RequestBody CurriculoModel curriculo){
        return repository.save(curriculo);
    }

    @DeleteMapping("/{id}")
    public void deleteCurriculo(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizarCurriculo(@PathVariable Long id, @RequestBody CurriculoModel curriculoAtualizado) {
        System.out.println("Atualizando currículo com ID: " + id);
        if (repository.existsById(id)) {
            repository.save(curriculoAtualizado);
        } else {
            System.out.println("Currículo com ID " + id + " não encontrado.");
        }
    }

   
}
