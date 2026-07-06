package com.gabrielLista.CadastroDeNinjas.Missoes;

import com.gabrielLista.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.nio.MappedByteBuffer;
import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //UMA MISSAO TEM MAIS DE UM NINJA
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;
    
}
