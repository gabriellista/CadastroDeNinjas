package com.gabrielLista.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    // GET--Mandar uma requisao para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return"Missãoes listadasc om sucesso";
    }
    // POST--Mandar uma requisao para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
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

}
