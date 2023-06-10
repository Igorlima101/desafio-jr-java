package com.igor.desafiojr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igor.desafiojr.model.dtos.ObraDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_obra")
public class Obra {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @Size(max = 240)
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDePublicacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeExposicao;

    @ManyToOne
    @JoinColumn(name = "id_author", referencedColumnName = "id")
    private Author author;

    public static Obra from(ObraDTO obraDto){
        Obra obra = new Obra();
        obra.setNome(obraDto.getNome());
        obra.setDescricao(obraDto.getDescricao());
        obra.setDataDePublicacao(obraDto.getDataDePublicacao());
        obra.setDataDeExposicao(obraDto.getDataDeExposicao());
        return obra;

    }

}
