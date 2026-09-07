package com.gabrielLista.CadastroDeNinjas.Ninjas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaUpdateDTO {
    private String nome;
    private String email;
    private String imUrl;
    private Integer idade;
    private String rank;
    private Long missaoId;
    private Boolean removerMissao;
}
