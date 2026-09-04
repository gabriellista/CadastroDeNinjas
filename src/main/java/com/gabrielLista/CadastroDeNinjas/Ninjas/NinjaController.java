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

    //ADICIONAR NINJA
    @PostMapping
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoNinja);
    }
    //MOSTRAR TODOS OS NINJAS
    @GetMapping
    public ResponseEntity <List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
            return ResponseEntity.ok(ninjas);

    }
    //MOSTRAR NINJA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarNinjasporId(@PathVariable Long id) {
        NinjaDTO ninjaListar = ninjaService.buscarNinjaPorId(id);
        if (ninjaListar != null){
            return ResponseEntity.ok(ninjaListar) ;
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
    }

    //ALTERAR NINJA
        @PutMapping("/{id}")
        public ResponseEntity<?> alterarNinjasporId(@PathVariable Long id,@RequestBody NinjaDTO ninjaDTO) {
           NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id, ninjaDTO);
           if (ninjaAtualizado != null){
               return ResponseEntity.ok(ninjaAtualizado);
           }else
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("O ninja com o id "+ id + " não foi encontrado");
        }

        //DELETAR NINJA
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
            if (ninjaService.buscarNinjaPorId(id) != null) {
                ninjaService.deletarNinjaPorId(id);
                return ResponseEntity.ok("Ninja com o ID" + id + "deletado com sucesso");
            }else
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("O ninja com o id " + id + " não encontrado");
        }
}
