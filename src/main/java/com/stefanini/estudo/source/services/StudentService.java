package com.stefanini.estudo.source.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stefanini.estudo.model.Endereco;
import com.stefanini.estudo.model.Student;
import com.stefanini.estudo.repository.EnderecoRepository;
import com.stefanini.estudo.repository.StudentRepository;
import com.stefanini.estudo.service.exceptions.ExistStudentException;
import com.stefanini.estudo.service.exceptions.StudentNotFoundException;

@Service
public class StudentService {

	@Autowired
	public StudentRepository repository;
	
	@Autowired
	EnderecoService enderecoService;
	
	public List<Student> findAll(){
		List<Student> students = repository.findAll();
		
		return students;
	}
	
	public void create (Student student) {
	/*	List<Student> aux = repository.findAll();
		Stream<Student> streamAux = aux.stream();
		if(streamAux.allMatch(s-> s.getMatricula().equals(student.getMatricula())))
		{
			throw new ExistStudentException("Matricula " + student.getMatricula() + " já existente");
		}
		else {*/
		
			Endereco enderecoAux = enderecoService.findById(student.getEndereco().getId());
			enderecoAux.addStudent(student);
			repository.save(student);	
		//}
		
	}
	
	public Optional<Student >findById(Integer id) {
		
		Optional<Student> student = repository.findById(id);
		if(student.isPresent())
			return student;
		else
			throw new StudentNotFoundException("Estudante com id: " + id+ " não encontrado");
		
	}
	
	public void update(Integer id, Student student) {
		
		Optional<Student>aux = repository.findById(id);
		
		if(aux.isPresent()) {
			aux.get().setMatricula(student.getMatricula());
			aux.get().setNome(student.getNome());
			aux.get().setEndereco(student.getEndereco());
			
			repository.save(aux.get());
		}else
			throw new StudentNotFoundException("Estudante com id: " + id+ " não encontrado");
		
	}
	
	public void delete(Integer id) {
		Optional<Student> student = repository.findById(id);
		if(student.isPresent()) {
			repository.deleteById(id);
			}else
				throw new StudentNotFoundException("id " +id);
		
	}
}
