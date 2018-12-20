package com.stefanini.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.estudo.model.StudentCurso;

public interface StudentCursoRepository extends JpaRepository<StudentCurso, Integer>  {

}
		