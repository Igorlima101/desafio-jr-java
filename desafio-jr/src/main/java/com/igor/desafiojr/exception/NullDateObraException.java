package com.igor.desafiojr.exception;

import com.igor.desafiojr.model.Obra;

import java.text.MessageFormat;

public class NullDateObraException extends RuntimeException{
    public NullDateObraException(Obra obra){
        super(MessageFormat.format("Pelo menos uma das datas devem ser fornecidas: ", obra.getDataDeExposicao() ,obra.getDataDePublicacao()));
    }
}
