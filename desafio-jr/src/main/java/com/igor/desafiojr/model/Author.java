package com.igor.desafiojr.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String id;

    @NotNull
    @NotEmpty
    private String nome;

    private String sexo;

    @Email
    private String email;

    @NotNull
    @NotEmpty
    private Date dataDeNascimento;

    private String paisDeOrigem;

    private String cpf;


}
