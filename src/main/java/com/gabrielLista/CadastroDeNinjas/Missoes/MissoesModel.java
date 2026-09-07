package com.gabrielLista.CadastroDeNinjas.Missoes;

import com.gabrielLista.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //UMA MISSAO TEM MAIS DE UM NINJA
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
