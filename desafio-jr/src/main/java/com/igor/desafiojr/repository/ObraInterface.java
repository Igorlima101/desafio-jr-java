package com.igor.desafiojr.repository;

import com.igor.desafiojr.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraInterface extends JpaRepository<Obra, Integer> {
}
