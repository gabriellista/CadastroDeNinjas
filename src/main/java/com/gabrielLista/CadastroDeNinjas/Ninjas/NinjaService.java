package com.gabrielLista.CadastroDeNinjas.Ninjas;

import com.gabrielLista.CadastroDeNinjas.Missoes.MissoesModel;
import com.gabrielLista.CadastroDeNinjas.Missoes.MissoesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final  NinjaMapper ninjaMapper;
    private final MissoesRepository missoesRepository;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper, MissoesRepository missoesRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
        this.missoesRepository = missoesRepository;
    }


    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }


    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }


    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }


    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO, Long missaoId) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaExistente.get();
            ninjaAtualizado.setNome(ninjaDTO.getNome());
            ninjaAtualizado.setEmail(ninjaDTO.getEmail());
            ninjaAtualizado.setRank(ninjaDTO.getRank());
            if (missaoId != null) {
                Optional<MissoesModel> missao =
                        missoesRepository.findById(missaoId);
                if (missao.isPresent()) {
                    ninjaAtualizado.setMissoes(missao.get());
                }
            } else {
                ninjaAtualizado.setMissoes(null);
            }
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);

        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaExistente.get();

            ninjaAtualizado.setNome(ninjaDTO.getNome());
            ninjaAtualizado.setEmail(ninjaDTO.getEmail());
            ninjaAtualizado.setRank(ninjaDTO.getRank());

            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);

            return ninjaMapper.map(ninjaSalvo);
        }

        return null;
    }
}