package com.project.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.main.models.CurriculoModel;
import com.project.main.repositories.CurriculoRepository;
import com.project.main.services.CurriculoService;

import java.util.List;

@RestController
@RequestMapping("/curriculos")
@CrossOrigin
public class CurriculoController {


    // @Autowired
    // private CurriculoService curriculoService;
    // private CurriculoRepository repository;

    // @GetMapping(value = "/listar")
    // public String listarCurriculos(Model model) {
        
    //     List<CurriculoModel> curriculos = curriculoService.obterTodosOsCurriculos();
    //     model.addAttribute("curriculos", curriculos);
    //     return "lista-curriculos"; // Nome da página a ser exibida (View)
    // }

    @Autowired
    CurriculoRepository repository;

    @GetMapping(value = "/listar")
    public List<CurriculoModel> listarCurriculos()  {
        System.out.println("Lista de curriculos");
        return repository.findAll();
    }

    @PostMapping
    public void Salvar(@RequestBody CurriculoModel curriculo){
        System.out.println("Enviando mais curriculos");
        repository.save(curriculo);
    }

    @DeleteMapping("/{id}")
    public void deleteCurriculo(@PathVariable Long id) {
        System.out.println("Deletando currículo com ID: " + id);
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

    // @GetMapping("/{id}")
    // public String visualizarCurriculo(@PathVariable Long id, Model model) {
    //     CurriculoModel curriculo = curriculoService.obterCurriculoPorId(id)
    //             .orElseThrow(() -> new IllegalArgumentException("Currículo não encontrado"));
    //     model.addAttribute("curriculo", curriculo);
    //     return "detalhes-curriculo"; // Nome da página a ser exibida (View)
    // }

    // @GetMapping("/novo")
    // public String novoCurriculoForm(Model model) {
    //     model.addAttribute("curriculo", new CurriculoModel());
    //     return "formulario-curriculo"; // Nome da página a ser exibida (View)
    // }

    // @PostMapping("/novo")
    // public String salvarNovoCurriculo(@ModelAttribute CurriculoModel curriculo) {
    //     curriculoService.salvarCurriculo(curriculo);
    //     return "redirect:/curriculos"; // Redireciona para a lista de currículos após salvar
    // }

    // @GetMapping("/{id}/editar")
    // public String editarCurriculoForm(@PathVariable Long id, Model model) {
    //     CurriculoModel curriculo = curriculoService.obterCurriculoPorId(id)
    //             .orElseThrow(() -> new IllegalArgumentException("Currículo não encontrado"));
    //     model.addAttribute("curriculo", curriculo);
    //     return "formulario-curriculo"; // Nome da página a ser exibida (View)
    // }

    // @PostMapping("/{id}/editar")
    // public String salvarCurriculoEditado(@PathVariable Long id, @ModelAttribute CurriculoModel curriculo) {
    //     curriculo.setId(id);
    //     curriculoService.salvarCurriculo(curriculo);
    //     return "redirect:/curriculos"; // Redireciona para a lista de currículos após salvar
    // }

    // @GetMapping("/{id}/excluir")
    // public String excluirCurriculo(@PathVariable Long id) {
    //     curriculoService.deletarCurriculo(id);
    //     return "redirect:/curriculos"; // Redireciona para a lista de currículos após excluir
    // }
}
