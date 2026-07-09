package com.gabrielLista.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }
    //MOSTRAR NINJA POR ID
    @GetMapping("/listarID")
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
