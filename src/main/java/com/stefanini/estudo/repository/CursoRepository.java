package com.stefanini.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.estudo.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
