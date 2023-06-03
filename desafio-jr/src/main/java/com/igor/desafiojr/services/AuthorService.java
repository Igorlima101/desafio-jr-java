package com.igor.desafiojr.services;

import com.igor.desafiojr.model.Author;
import com.igor.desafiojr.repository.AuthorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorInterface authorInterface;

    public List<Author> listAllAuthor() {
        return authorInterface.findAll();
    }

    public void saveAuthor(Author author){
        if(author.getPaisDeOrigem().contains("brasil")&& author.getCpf().isBlank()){
            throw new NullPointerException("O campo cpf precisa ser preenchido");
        }


       authorInterface.save(author);
    }

}

