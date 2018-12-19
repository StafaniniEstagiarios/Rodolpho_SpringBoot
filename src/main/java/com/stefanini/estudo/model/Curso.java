package com.stefanini.estudo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@Entity
public class Curso implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	private String nomeDisciplina;
	
	@JsonIgnore
	@ManyToMany(mappedBy="cursos")
	private List<Student> student;
	
	
	public Curso() {
		super();
	}
	

	public Curso(Integer id, String nomeDisciplina, List<Student> student) {
		super();
		this.id = id;
		this.nomeDisciplina = nomeDisciplina;
		this.student = student;
	}


	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	
	
}
