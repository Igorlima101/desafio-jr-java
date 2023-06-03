package com.igor.desafiojr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @OneToMany
    @JoinColumn(name = "id_author", referencedColumnName = "id")
    private List<Author> author = new ArrayList<>();

}
