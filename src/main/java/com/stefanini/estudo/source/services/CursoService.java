package com.stefanini.estudo.source.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.estudo.model.Curso;
import com.stefanini.estudo.repository.CursoRepository;
import com.stefanini.estudo.service.exceptions.EnderecoNotFound;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	
	public Curso findById(Integer id){
		Optional<Curso> endereco = cursoRepository.findById(id);
		
		if(endereco.isPresent()) {
			return endereco.get();
		}
		else 
			throw new EnderecoNotFound("Endereço com id: "+ id+" não encontrado.");			
	}

	public void create(Curso endereco) {
		cursoRepository.save(endereco);
	}
	
	public void delete(Integer id) {
		Optional<Curso> endereco = cursoRepository.findById(id);
		
		if(endereco.isPresent()) {
			cursoRepository.deleteById(id);
		}
		else 
			throw new EnderecoNotFound("Endereço com id: "+ id+" não encontrado.");			
	}
	
	public void update(Integer id, Curso curso) {
		Optional<Curso> aux = cursoRepository.findById(id);
		
		if(aux.isPresent()) {
			aux.get().setNomeDisciplina(curso.getNomeDisciplina());
			cursoRepository.save(aux.get());
		}
		else
			throw new EnderecoNotFound("Endereço com id: "+ id+" não encontrado.");	
		
	}

}
