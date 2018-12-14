package com.stefanini.estudo.source.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stefanini.estudo.model.Student;
import com.stefanini.estudo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	public StudentRepository repository;
	
	public List<Student> findAll(){
		List<Student> students = repository.findAll();
		
		return students;
	}
	
	public void create (Student student) {
		repository.save(student);
	}
	
	public Optional<Student >findById(Integer id) {
		
		Optional<Student> student = repository.findById(id);
		
		return student;
	}
	
	public void update(Integer id, Student student) {
		
		Optional<Student>aux = repository.findById(id);
		aux.get().setMatricula(student.getMatricula());
		aux.get().setNome(student.getNome());
		
		repository.save(aux.get());
		
		
	}
}
