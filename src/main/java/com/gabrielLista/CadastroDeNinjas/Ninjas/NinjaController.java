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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }
    //MOSTRAR TODOS OS NINJAS
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }
    //MOSTRAR NINJA POR ID
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasporId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //ALTERAR NINJA
        @PutMapping("/alterar/{id}")
        public NinjaModel alterarNinjasporId(@PathVariable Long id,@RequestBody NinjaModel ninjaAtualizado) {
            return ninjaService.atualizarNinja(id,ninjaAtualizado);
        }

        //DELETAR NINJA
        @DeleteMapping("/deletar/{id}")
        public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }
}
