package com.stefanini.estudo.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stefanini.estudo.model.Student;
import com.stefanini.estudo.source.services.StudentService;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;


@RestController
public class StudentSources {

	@Autowired
	StudentService service;
	
	@GetMapping(value="/students")
	public ResponseEntity<List<Student>> findAll(){
		List<Student> students = service.findAll();
		return ResponseEntity.ok().body(students);
	}
	
	@PostMapping(value="/students")
	public ResponseEntity<Void> create(@RequestBody Student student){
		
		service.create(student);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value="/students/{id}")
	public ResponseEntity<Optional<Student>> findById(@PathVariable Integer id){
		
		Optional<Student> student = service.findById(id);
		
		return ResponseEntity.ok().body(student);
	}
	
	@PutMapping(value="/students/{id}")
	public ResponseEntity<Void> update(@RequestBody Student student, @PathVariable Integer id){
		
		service.update(id, student);		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value="/students/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
}
