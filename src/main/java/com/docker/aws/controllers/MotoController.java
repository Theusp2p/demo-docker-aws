package com.docker.aws.controllers;

import com.docker.aws.models.Moto;
import com.docker.aws.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MotoController {

    @Autowired
    private MotoService service;

    // Carrega a página inicial com a lista e o formulário vazio
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("motos", service.listarTodas());
        model.addAttribute("novaMoto", new Moto());
        return "index";
    }

    // Recebe os dados do formulário e salva no banco H2
    @PostMapping("/salvar")
    public String salvarMoto(@ModelAttribute Moto moto) {
        service.salvar(moto);
        return "redirect:/"; // Atualiza a página após salvar
    }

    // Exclui uma moto pelo ID
    @GetMapping("/deletar/{id}")
    public String deletarMoto(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/";
    }
}