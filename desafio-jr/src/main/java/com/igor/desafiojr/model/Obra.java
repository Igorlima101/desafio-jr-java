package com.igor.desafiojr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_obra")
public class Obra {


    private String id;

    @NotNull
    private String nome;

    @Size(max = 240)
    private String descricao;
    private Date dataDePublicacao;
    private Date dataDeExposicao;

}
