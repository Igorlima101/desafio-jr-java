package com.igor.desafiojr.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igor.desafiojr.model.Author;
import com.igor.desafiojr.model.Obra;
import lombok.Data;

import java.util.Date;

@Data
public class ObraDTO {

    private Integer id;
    private String nome;
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDePublicacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeExposicao;
    private Author author;

    public static ObraDTO from(Obra obra){
        ObraDTO obraDTO = new ObraDTO();
        obraDTO.setId(obra.getId());
        obraDTO.setNome(obra.getNome());
        obraDTO.setDescricao(obra.getDescricao());
        obraDTO.setDataDePublicacao(obra.getDataDePublicacao());
        obraDTO.setDataDeExposicao(obra.getDataDeExposicao());
        return obraDTO;

    }


}
