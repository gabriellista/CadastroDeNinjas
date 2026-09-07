package com.gabrielLista.CadastroDeNinjas.Ninjas;

import com.gabrielLista.CadastroDeNinjas.Missoes.MissoesMapper;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    private final MissoesMapper missoesMapper;

    public NinjaMapper(MissoesMapper missoesMapper) {
        this.missoesMapper = missoesMapper;
    }

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        if (ninjaDTO.getIdade() != null) {
            ninjaModel.setIdade(ninjaDTO.getIdade());
        }
        ninjaModel.setImUrl(ninjaDTO.getImUrl());
        ninjaModel.setRank(ninjaDTO.getRank());
        if (ninjaDTO.getMissoes() != null) {
            ninjaModel.setMissoes(
                    missoesMapper.map(ninjaDTO.getMissoes())
            );
        }
        return ninjaModel;
    }
    public NinjaDTO map(NinjaModel ninjaModel){

        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setImUrl(ninjaModel.getImUrl());
        ninjaDTO.setRank(ninjaModel.getRank());
        if (ninjaModel.getMissoes() != null) {
            ninjaDTO.setMissoes(
                    missoesMapper.map(ninjaModel.getMissoes())
            );
        }

        return ninjaDTO;
    }

}
