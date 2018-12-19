package com.stefanini.estudo.source;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.estudo.model.Endereco;
import com.stefanini.estudo.source.services.EnderecoService;
import com.stefanini.estudo.source.services.GenericService;

@RestController
@RequestMapping(value="/endereco")
public class EnderecoSource {
	
	@Autowired
	EnderecoService service;
	
	@Autowired
	GenericService<Endereco> service1;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Integer id){
		
		
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Endereco endereco){
		
		service.create(endereco);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll(){
		
		List<Endereco> enderecos = service.findAll();
		
		return ResponseEntity.ok().body(enderecos);
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id,@RequestBody Endereco endereco){
		
		service.update(id, endereco);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		
		return ResponseEntity.ok().build();
	}

}
