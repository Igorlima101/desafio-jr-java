package com.igor.desafiojr.controllers;

import com.igor.desafiojr.model.Author;
import com.igor.desafiojr.model.dtos.AuthorDTO;
import com.igor.desafiojr.repository.AuthorInterface;
import com.igor.desafiojr.repository.ObraInterface;
import com.igor.desafiojr.services.AuthorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorInterface authorInterface;

    @Autowired
    private ObraInterface obraInterface;

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDTO>> lists(){
        List<Author> author = authorService.listarAuthores();
        List<AuthorDTO> authorDto = author.stream().map(AuthorDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(authorDto, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody final AuthorDTO authorDto){
        Author author = authorService.criarAuthor(Author.from(authorDto));
        return new ResponseEntity<>(AuthorDTO.from(author), HttpStatus.CREATED);
    }

    @PostMapping("/post/{idAuthor}/{idObra}")
    public ResponseEntity<AuthorDTO> authorObras(@PathVariable final Integer idAuthor, @PathVariable final Integer idObra){
        Author author = authorService.adicionarObraAuthor(idAuthor, idObra);
        return new ResponseEntity<>(AuthorDTO.from(author), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idAuthor}/{idObra}")
    public ResponseEntity<AuthorDTO> deletarObraAuthor(@PathVariable final Integer idAuthor, @PathVariable final Integer idObra){
        Author author = authorService.removerObra(idAuthor, idObra);
        return new ResponseEntity<>(AuthorDTO.from(author), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorDTO> deleteAuthor(@PathVariable final Integer id){
        Author author = authorService.deletarAuthor(id);
        return new ResponseEntity<>(AuthorDTO.from(author), HttpStatus.OK);

    }
}
