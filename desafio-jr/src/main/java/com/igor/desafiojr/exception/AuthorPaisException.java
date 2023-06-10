package com.igor.desafiojr.exception;

import com.igor.desafiojr.model.Author;

import java.text.MessageFormat;


public class AuthorPaisException extends RuntimeException{

    public AuthorPaisException(Author author){
        super(MessageFormat.format("O campo cpf, precisa ser preenchido, se o país for brasil", author.getPaisDeOrigem()));
    }
}
