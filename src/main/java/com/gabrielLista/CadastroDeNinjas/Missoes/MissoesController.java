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

    @GetMapping("/{id}")
    public ResponseEntity<MissoesDTO> buscarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.buscarMissaoPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissoesDTO> atualizarMissao(
            @PathVariable Long id,
            @RequestBody MissoesDTO missaoDTO) {
        MissoesDTO missaoAtualizada = missoesService.atualizarMissao(id, missaoDTO);
        if (missaoAtualizada != null) {
            return ResponseEntity.ok(missaoAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMissao(
            @PathVariable Long id) {
        boolean deletada = missoesService.deletarMissao(id);
        if (deletada) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
