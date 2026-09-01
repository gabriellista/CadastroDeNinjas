package com.gabrielLista.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/missoes")

public class MissoesViewController {

    private final MissoesService missoesService;

    public MissoesViewController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping
    public String listarMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "missoes/lista";
    }

    @GetMapping("/{id}/editar")
    public String exibirFormularioEdicao(@PathVariable Long id,Model model){
        MissoesDTO missao = missoesService.buscarMissaoPorId(id);
        model.addAttribute("missao",missao);
        return "missoes/editar";
    }

    @PostMapping("/{id}/editar")
    public String salvarEdicao(@PathVariable Long id, @ModelAttribute MissoesDTO missoesDTO){
        MissoesDTO missao = missoesService.atualizarMissao(id, missoesDTO);
        return "redirect:/web/missoes";
    }

    @PostMapping("/{id}/excluir")
    public String excluirMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
        return "redirect:/web/missoes";
    }

    @GetMapping ("/nova")
    public String exibirFormularioCriacao(Model model) {
        MissoesDTO missao = new MissoesDTO();
        model.addAttribute("missao", missao);
        return "missoes/criar";
    }

    @PostMapping("/nova")
    public String criarMissao(@ModelAttribute MissoesDTO missaoDTO){
        missoesService.criarMissao(missaoDTO);
        return "redirect:/web/missoes";
    }
}
