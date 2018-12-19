package com.stefanini.estudo.source.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.estudo.model.Curso;
import com.stefanini.estudo.repository.CursoRepository;
import com.stefanini.estudo.repository.GenericRepository;

@Service
public class GenericService <T> {

	@Autowired
	GenericRepository<T> repository;
	
	public List<T> findAll(){
		return repository.findAll();
	}
}
