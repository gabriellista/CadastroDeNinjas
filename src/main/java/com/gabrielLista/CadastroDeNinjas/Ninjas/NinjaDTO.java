package com.gabrielLista.CadastroDeNinjas.Ninjas;

import com.gabrielLista.CadastroDeNinjas.Missoes.MissoesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imUrl;
    private Integer idade;
    private String rank;
    private MissoesDTO missoes;

}
