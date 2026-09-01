package com.gabrielLista.CadastroDeNinjas.Missoes;

import com.gabrielLista.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import com.gabrielLista.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service

public class MissoesService {
    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;
    private final NinjaRepository ninjaRepository;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper, NinjaRepository ninjaRepository) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
        this.ninjaRepository = ninjaRepository;
    }

    public List<MissoesDTO> listarMissoes() {
        return missoesRepository.findAll()
                .stream()
                .map(missoesMapper::map)
                .toList();
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO) {
        MissoesModel missao = missoesMapper.map(missaoDTO);
        MissoesModel missaoSalva = missoesRepository.save(missao);
        return missoesMapper.map(missaoSalva);
    }

    public MissoesDTO buscarMissaoPorId(Long id) {
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        if (missao.isPresent()) {
            return missoesMapper.map(missao.get());
        }
        return null;
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missaoDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {

            MissoesModel missaoAtualizada = missaoExistente.get();
            missaoAtualizada.setNome(missaoDTO.getNome());
            missaoAtualizada.setDificuldade(missaoDTO.getDificuldade());

            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

    @Transactional
    public boolean deletarMissao(Long id) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()) {
            List<NinjaModel> ninjas =
                    ninjaRepository.findByMissoes_Id(id);
            for (NinjaModel ninja : ninjas) {
                ninja.setMissoes(null);
            }
            ninjaRepository.saveAll(ninjas);
            missoesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
