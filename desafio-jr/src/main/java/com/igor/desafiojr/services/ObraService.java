package com.igor.desafiojr.services;


import com.igor.desafiojr.exception.NullDateObraException;
import com.igor.desafiojr.exception.ObraNotFoundException;
import com.igor.desafiojr.model.Obra;
import com.igor.desafiojr.repository.AuthorInterface;
import com.igor.desafiojr.repository.ObraInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraService {

    @Autowired
    private AuthorInterface authorInterface;

    @Autowired
    private ObraInterface obraInterface;


   public List<Obra> listarObras(){
      return StreamSupport
               .stream(obraInterface.findAll().spliterator(), false)
               .collect(Collectors.toList());
   }

   public Obra pegarObra(Integer id){
       return obraInterface.findById(id).orElseThrow(() ->
               new ObraNotFoundException(id));
   }

   public Obra deletarObra(Integer id){
       Obra obra = pegarObra(id);
       obraInterface.delete(obra);
       return obra;
   }

    public Obra criarObra(Obra obra){

        if(obra.getDataDePublicacao() == null && obra.getDataDeExposicao() == null){
            throw new NullDateObraException(obra);
        }

        return obraInterface.save(obra);
    }
}
