package com.gabrielLista.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso" + novoNinja.getNome() + "(id): " + novoNinja);
    }
    //MOSTRAR TODOS OS NINJAS
    @GetMapping("/listar")
    public ResponseEntity <List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
            return ResponseEntity.ok(ninjas);

    }
    //MOSTRAR NINJA POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasporId(@PathVariable Long id) {
        NinjaDTO ninjaListar = ninjaService.listarNinjasPorId(id);
        if (ninjaListar != null){
            return ResponseEntity.ok(ninjaListar) ;
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
    }

    //ALTERAR NINJA
        @PutMapping("/alterar/{id}")
        public ResponseEntity<?> alterarNinjasporId(@PathVariable Long id,@RequestBody NinjaDTO ninjaDTO) {
           NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id,ninjaDTO);
           if (ninjaAtualizado != null){
               return ResponseEntity.ok(ninjaAtualizado);
           }else
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("O ninja com o id "+ id + " não foi encontrado");
        }

        //DELETAR NINJA
        @DeleteMapping("/deletar/{id}")
        public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
            if (ninjaService.listarNinjasPorId(id) != null) {
                ninjaService.deletarNinjaPorId(id);
                return ResponseEntity.ok("Ninja com o ID" + id + "deletado com sucesso");
            }else
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("O ninja com o id " + id + " não encontrado");
        }
}
