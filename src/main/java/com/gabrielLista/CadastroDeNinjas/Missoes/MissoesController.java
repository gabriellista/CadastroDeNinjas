package com.gabrielLista.CadastroDeNinjas.Missoes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET--Mandar uma requisao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    // POST--Mandar uma requisao para criar as missoes
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missaoDTO) {
        return missoesService.criarMissao(missaoDTO);
    }


    // PUT--Mandar uma requisao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    // DEL--Mandar uma requisao para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissoesDTO> buscarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.buscarMissaoPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.notFound().build();
    }

}
