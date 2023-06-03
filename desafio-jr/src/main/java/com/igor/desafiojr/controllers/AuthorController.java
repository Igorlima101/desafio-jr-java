package com.igor.desafiojr.controllers;

import com.igor.desafiojr.model.Author;
import com.igor.desafiojr.repository.AuthorInterface;
import com.igor.desafiojr.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorInterface authorInterface;

    @GetMapping("/all")
    public ResponseEntity<List<Author>> lists(){
        return ResponseEntity.ok().body(authorService.listAllAuthor());
    }

    @PostMapping("/post")
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author){
        authorService.saveAuthor(author);
        return ResponseEntity.ok().body(author);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Integer id){
        if(!authorInterface.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        authorInterface.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
