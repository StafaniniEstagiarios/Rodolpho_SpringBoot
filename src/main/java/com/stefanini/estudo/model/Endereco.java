package com.stefanini.estudo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private String rua;
	private String bairro;
	private Integer numero;
	
	@JsonIgnore
	@OneToMany(mappedBy="endereco")
	private List<Student> students = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
	public Endereco() {
		super();
	}
	public List<Student> getStudents() {
		return students;
	}
	public void addStudent(Student student) {
		this.students.add(student);
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Endereco(Integer id, String rua, String bairro, Integer numero, List<Student> students) {
		super();
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.students = students;
	}
	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", bairro=" + bairro + ", numero=" + numero + ", students="
				+ students + "]";
	}
	

	
	
	
}
