package com.igor.desafiojr.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igor.desafiojr.model.Author;
import com.igor.desafiojr.model.Obra;
import lombok.Data;

import javax.validation.constraints.PastOrPresent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AuthorDTO {
    private Integer id;
    private String nome;
    private String sexo;
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeNascimento;
    private String paisDeOrigem;
    private String cpf;
    private List<ObraDTO> obraDoAuthor = new ArrayList<>();

    public static AuthorDTO from(Author author){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setNome(author.getNome());
        authorDTO.setSexo(author.getSexo());
        authorDTO.setEmail(author.getEmail());
        authorDTO.setDataDeNascimento(author.getDataDeNascimento());
        authorDTO.setPaisDeOrigem(author.getPaisDeOrigem());
        authorDTO.setCpf(author.getCpf());
        authorDTO.setObraDoAuthor(author.getObras().stream().map(ObraDTO::from).collect(Collectors.toList()));
        return authorDTO;
    }
}
