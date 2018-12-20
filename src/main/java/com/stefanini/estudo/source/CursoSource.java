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
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.estudo.model.Curso;
import com.stefanini.estudo.source.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoSource {

	@Autowired
	private CursoService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Integer id){
		
		
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Curso curso){
		
		service.create(curso);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll(){
		
		List<Curso> cursos = service.findAll();
		
		return ResponseEntity.ok().body(cursos);
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id,@RequestBody Curso endereco){
		
		service.update(id, endereco);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		
		return ResponseEntity.ok().build();
	}
	
}
