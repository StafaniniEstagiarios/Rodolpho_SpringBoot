package com.stefanini.estudo.source.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.estudo.model.Endereco;
import com.stefanini.estudo.repository.EnderecoRepository;
import com.stefanini.estudo.service.exceptions.EnderecoNotFound;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public Endereco findById(Integer id){
		Optional<Endereco> endereco = repository.findById(id);
		
		if(endereco.isPresent()) {
			return endereco.get();
		}
		else 
			throw new EnderecoNotFound("Endereço com id: "+ id+" não encontrado.");			
	}

	public void create(Endereco endereco) {
		repository.save(endereco);
	}
	
	public void delete(Integer id) {
		Optional<Endereco> endereco = repository.findById(id);
		
		if(endereco.isPresent()) {
			repository.deleteById(id);
		}
		else 
			throw new EnderecoNotFound("Endereço com id: "+ id+" não encontrado.");			
	}
	
	public void update(Integer id, Endereco endereco) {
		Optional<Endereco> aux = repository.findById(id);
		
		if(aux.isPresent()) {
			aux.get().setBairro(endereco.getBairro());
			aux.get().setNumero(endereco.getNumero());
			aux.get().setRua(endereco.getRua());
			repository.save(aux.get());
		}
		else
			throw new EnderecoNotFound("Endereço com id: "+ id+" não encontrado.");	
		
	}

}

