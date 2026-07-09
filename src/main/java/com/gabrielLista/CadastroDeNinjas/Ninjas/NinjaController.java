package com.gabrielLista.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem";
    }
    //ADICIONAR NINJA
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }
    //MOSTRAR TODOS OS NINJAS
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }
    //MOSTRAR NINJA POR ID
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasporId() {
        return "Mostrar Ninja por ID";
    }

    //ALTERAR NINJA
        @PutMapping("/alterarID")
        public String alterarNinjasporId() {
            return "Alterar Ninja por ID";
        }

        //DELETAR NINJA
        @DeleteMapping("/deletarID")
        public String deletarNinjaPorId() {
            return "deletar";
        }
}
