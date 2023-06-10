package com.igor.desafiojr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igor.desafiojr.model.dtos.AuthorDTO;
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
import java.util.Set;


@Getter
@Setter
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
    private List<Obra> obras = new ArrayList<>();

    public void adicionarObra(Obra obra){
        obras.add(obra);
    }

    public void removeObra(Obra obra){
        obras.remove(obra);
    }

    public static Author from(AuthorDTO authorDto){
        Author author = new Author();
        author.setNome(authorDto.getNome());
        author.setSexo(authorDto.getSexo());
        author.setEmail(authorDto.getEmail());
        author.setDataDeNascimento(authorDto.getDataDeNascimento());
        author.setPaisDeOrigem(authorDto.getPaisDeOrigem());
        author.setCpf(authorDto.getCpf());
        return author;
    }


}
