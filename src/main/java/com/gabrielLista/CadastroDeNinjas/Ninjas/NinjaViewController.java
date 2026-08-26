package com.gabrielLista.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/ninjas")
public class NinjaViewController {

    private final NinjaService ninjaService;

    public NinjaViewController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping
    public String exibirListaDeNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "ninjas/listar";
    }

    @GetMapping("/{id}/editar")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        model.addAttribute("ninja", ninja);
        return "ninjas/editar";
    }

    @PostMapping("/{id}/editar")
    public String salvarEdicao(
            @PathVariable Long id,
            @ModelAttribute NinjaDTO ninja) {
        ninjaService.atualizarNinja(id, ninja);
        return "redirect:/web/ninjas";
    }
}