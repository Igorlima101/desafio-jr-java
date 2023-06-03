package com.igor.desafiojr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
    private String nome;

    private String sexo;

    @Email
    private String email;

    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeNascimento;

    @NotNull
    @NotEmpty
    private String paisDeOrigem;

    @CPF
    private String cpf;

    @OneToMany
    @JoinColumn(name = "id_obra", referencedColumnName = "id")
    private List<Obra> obra = new ArrayList<>();


}
