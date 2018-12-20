package com.stefanini.estudo.builder;

import org.springframework.beans.factory.annotation.Autowired;

import com.stefanini.estudo.dto.StudentDTO;
import com.stefanini.estudo.model.Endereco;
import com.stefanini.estudo.model.Student;
import com.stefanini.estudo.repository.EnderecoRepository;

public class StudentBuilder {

	
	public static Student toStudent(StudentDTO studentDTO, Endereco endereco) {
		
		
		
		Student student = new Student();
		student.setMatricula(studentDTO.getMatricula());
		student.setNome(studentDTO.getNome());
		student.setEndereco(endereco);
		
		return student;
	}
	
}
