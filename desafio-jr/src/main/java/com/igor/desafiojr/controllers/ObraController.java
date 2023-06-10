package com.igor.desafiojr.controllers;

import com.igor.desafiojr.model.Author;
import com.igor.desafiojr.model.Obra;
import com.igor.desafiojr.model.dtos.AuthorDTO;
import com.igor.desafiojr.model.dtos.ObraDTO;
import com.igor.desafiojr.repository.AuthorInterface;
import com.igor.desafiojr.repository.ObraInterface;
import com.igor.desafiojr.services.ObraService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/obra")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @Autowired
    private ObraInterface obraInterface;

    @Autowired
    private AuthorInterface authorInterface;

    @GetMapping("/list")
    public ResponseEntity<List<ObraDTO>> list() {
        List<Obra> listaObras = obraService.listarObras();
        List<ObraDTO> obraDto = listaObras.stream().map(ObraDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(obraDto, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<ObraDTO> salvarObra(@Valid @RequestBody final ObraDTO obraDto) {

        Obra obra = obraService.criarObra(Obra.from(obraDto));
        return new ResponseEntity<>(ObraDTO.from(obra), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ObraDTO> deletarObras(@PathVariable final Integer id){
        Obra obra = obraService.deletarObra(id);
        return new ResponseEntity<>(ObraDTO.from(obra), HttpStatus.OK);
    }
}
