package com.gabrielLista.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    //LISTAR TODOS OS MEUS NINJAS
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }
    //LISTAR TODOS OS MEU NINJAS
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId=ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }
    //CRIAR UM NOVO NINJA
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

}
