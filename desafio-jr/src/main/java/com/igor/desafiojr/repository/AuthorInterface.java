package com.igor.desafiojr.repository;

import com.igor.desafiojr.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorInterface extends JpaRepository<Author,Integer> {


}
