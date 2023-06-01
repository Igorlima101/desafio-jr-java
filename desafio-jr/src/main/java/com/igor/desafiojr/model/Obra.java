package com.igor.desafiojr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_obra")
public class Obra {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotNull
    private String nome;

    @Size(max = 240)
    private String descricao;

    private Date dataDePublicacao;

    private Date dataDeExposicao;

    @OneToMany
    @JoinColumn(name = "id_author", referencedColumnName = "id")
    private List<Author> author = new ArrayList<>();

}
