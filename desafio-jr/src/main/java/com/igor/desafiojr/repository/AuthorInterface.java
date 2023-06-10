package com.igor.desafiojr.repository;

import com.igor.desafiojr.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface AuthorInterface extends JpaRepository<Author, Integer> {

    List<Author> findByNome(String nome);
}

