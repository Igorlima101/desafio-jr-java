package com.igor.desafiojr.exception;

import java.text.MessageFormat;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Integer id){
        super(MessageFormat.format("Não foi possivel localizar o id: {0} , do author ", id));
    }

}
