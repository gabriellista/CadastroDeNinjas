package com.gabrielLista.CadastroDeNinjas.Ninjas;

import com.gabrielLista.CadastroDeNinjas.Missoes.MissoesDTO;
import com.gabrielLista.CadastroDeNinjas.Missoes.MissoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/web/ninjas")
public class NinjaViewController {

    private final NinjaService ninjaService;
    private final MissoesService missoesService;

    public NinjaViewController(NinjaService ninjaService, MissoesService missoesService) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
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
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("ninja", ninja);
        model.addAttribute("missoes", missoes);
        return "ninjas/editar";
    }

    @PostMapping("/{id}/editar")
    public String salvarEdicao(@PathVariable Long id,
                               @ModelAttribute NinjaDTO ninja,
                               @RequestParam(required = false) Long missaoId) {
        ninjaService.atualizarNinja(id, ninja, missaoId);
        return "redirect:/web/ninjas";
    }

    @GetMapping("/novo")
    public String exibirFormularioCriacao(Model model){
        NinjaDTO ninja = new NinjaDTO();
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("ninja", ninja);
        model.addAttribute("missoes", missoes);
        return "ninjas/criar";
    }

    @PostMapping("/novo")
    public String criarNinja(
            @ModelAttribute NinjaDTO ninjaDTO,
            @RequestParam(required = false) Long missaoId) {
        ninjaService.criarNinja(ninjaDTO, missaoId);
        return "redirect:/web/ninjas";
    }

    @PostMapping("/{id}/excluir")
    public String excluirNinja(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/web/ninjas";
    }
}