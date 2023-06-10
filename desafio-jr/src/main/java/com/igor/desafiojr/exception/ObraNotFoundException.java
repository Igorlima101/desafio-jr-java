package com.igor.desafiojr.exception;

import java.text.MessageFormat;

public class ObraNotFoundException extends RuntimeException {

    public ObraNotFoundException(Integer id){
        super(MessageFormat.format("Não foi possivel localizar o id: {0} , da obra", id));
    }
}
