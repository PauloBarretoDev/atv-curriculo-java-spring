package com.project.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.main.models.CurriculoModel;
import com.project.main.services.CurriculoService;

import java.util.List;

@RestController
@RequestMapping("/curriculos")
@CrossOrigin
public class CurriculoController {


    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public String listarCurriculos(Model model) {
        List<CurriculoModel> curriculos = curriculoService.obterTodosOsCurriculos();
        model.addAttribute("curriculos", curriculos);
        return "lista-curriculos"; // Nome da página a ser exibida (View)
    }

    @GetMapping("/{id}")
    public String visualizarCurriculo(@PathVariable Long id, Model model) {
        CurriculoModel curriculo = curriculoService.obterCurriculoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Currículo não encontrado"));
        model.addAttribute("curriculo", curriculo);
        return "detalhes-curriculo"; // Nome da página a ser exibida (View)
    }

    @GetMapping("/novo")
    public String novoCurriculoForm(Model model) {
        model.addAttribute("curriculo", new CurriculoModel());
        return "formulario-curriculo"; // Nome da página a ser exibida (View)
    }

    @PostMapping("/novo")
    public String salvarNovoCurriculo(@ModelAttribute CurriculoModel curriculo) {
        curriculoService.salvarCurriculo(curriculo);
        return "redirect:/curriculos"; // Redireciona para a lista de currículos após salvar
    }

    @GetMapping("/{id}/editar")
    public String editarCurriculoForm(@PathVariable Long id, Model model) {
        CurriculoModel curriculo = curriculoService.obterCurriculoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Currículo não encontrado"));
        model.addAttribute("curriculo", curriculo);
        return "formulario-curriculo"; // Nome da página a ser exibida (View)
    }

    @PostMapping("/{id}/editar")
    public String salvarCurriculoEditado(@PathVariable Long id, @ModelAttribute CurriculoModel curriculo) {
        curriculo.setId(id);
        curriculoService.salvarCurriculo(curriculo);
        return "redirect:/curriculos"; // Redireciona para a lista de currículos após salvar
    }

    @GetMapping("/{id}/excluir")
    public String excluirCurriculo(@PathVariable Long id) {
        curriculoService.deletarCurriculo(id);
        return "redirect:/curriculos"; // Redireciona para a lista de currículos após excluir
    }
}
