package com.igor.desafiojr.services;

import com.igor.desafiojr.exception.AuthorNotFoundException;
import com.igor.desafiojr.exception.AuthorPaisException;
import com.igor.desafiojr.model.Author;
import com.igor.desafiojr.model.Obra;
import com.igor.desafiojr.repository.AuthorInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorService {

    @Autowired
    private AuthorInterface authorInterface;

    @Autowired
    private ObraService obraService;

    public List<Author> listarAuthores(){
        return StreamSupport
                .stream(authorInterface.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Author pegarAuthor(Integer id){
        return authorInterface.findById(id).orElseThrow(() ->
                new AuthorNotFoundException(id));
    }

    public Author deletarAuthor(Integer id){
        Author author = pegarAuthor(id);
        authorInterface.delete(author);
        return author;

    }

    @Transactional
    public Author criarAuthor(Author author){
        if(author.getPaisDeOrigem().contains("brasil")&& author.getCpf().isBlank()){
            throw new AuthorPaisException(author);
        }
       return authorInterface.save(author);
    }

    @Transactional
    public Author adicionarObraAuthor(Integer idAuthor, Integer idObra){
        Author author = pegarAuthor(idAuthor);
        Obra obra = obraService.pegarObra(idObra);
        if(Objects.nonNull(obra.getAuthor())){
            throw new Error("qualquer coisa por enquanto");
        }
        author.adicionarObra(obra);
        obra.setAuthor(author);
        return author;
    }

    public Author removerObra(Integer idAuthor, Integer idObra){
        Author author = pegarAuthor(idAuthor);
        Obra obra = obraService.pegarObra(idObra);
        author.removeObra(obra);
        return author;
    }


}

