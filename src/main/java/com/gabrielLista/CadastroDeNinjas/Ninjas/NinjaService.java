package com.gabrielLista.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja =ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //DELETAR UM NINJA- ter que ser um metido void
    public void deletarNinjaPorId(Long id ){
        ninjaRepository.deleteById(id);
    }

    //ATUALIZAR NINJA
    public NinjaModel atualizarNinja(Long id,NinjaModel ninjaAtualizado ){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
