package com.stefanini.estudo.source.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stefanini.estudo.builder.StudentBuilder;
import com.stefanini.estudo.dto.StudentDTO;
import com.stefanini.estudo.model.Curso;
import com.stefanini.estudo.model.Endereco;
import com.stefanini.estudo.model.Student;
import com.stefanini.estudo.model.StudentCurso;
import com.stefanini.estudo.model.StudentCursoChaveComposta;
import com.stefanini.estudo.repository.CursoRepository;
import com.stefanini.estudo.repository.EnderecoRepository;
import com.stefanini.estudo.repository.StudentCursoRepository;
import com.stefanini.estudo.repository.StudentRepository;
import com.stefanini.estudo.service.exceptions.ExistStudentException;
import com.stefanini.estudo.service.exceptions.StudentNotFoundException;

@Service
public class StudentService {

	@Autowired
	public StudentRepository studentRepository;
	
	@Autowired
	public StudentCursoRepository studentCursoRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	CursoRepository cursoRepository;
	
	public List<Student> findAll(){
		List<Student> students = studentRepository.findAll();
		
		return students;
	}
	
	public void createStudent(StudentDTO studentDTO) {

		List<Integer> cursos = studentDTO.getListaCursos();
		enderecoService.findById(studentDTO.getEnderecoId());
		Student student = studentRepository.save(StudentBuilder.toStudent(studentDTO,enderecoService.findById(studentDTO.getEnderecoId())));
		
		
		for (Integer idCurso : cursos ) {

			studentCursoRepository.save(new StudentCurso(student, cursoRepository.findById(idCurso).get()));
		}
		
	}
	
	public Optional<Student >findById(Integer id) {
		
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return student;
		} else {
			throw new StudentNotFoundException("Estudante com id: " + id + " não encontrado");
		}
	}
	
	public void update(Integer id, Student student) {
		
		Optional<Student> aux = studentRepository.findById(id);
		
		if(aux.isPresent()) {
			aux.get().setMatricula(student.getMatricula());
			aux.get().setNome(student.getNome());
			aux.get().setEndereco(student.getEndereco());
			
			studentRepository.save(aux.get());
		}else
			throw new StudentNotFoundException("Estudante com id: " + id+ " não encontrado");
		
	}
	
	public void delete(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
			}else
				throw new StudentNotFoundException("id " +id);
		
	}
}
