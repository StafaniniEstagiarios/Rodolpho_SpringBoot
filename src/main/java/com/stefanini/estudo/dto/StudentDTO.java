package com.stefanini.estudo.dto;

import java.util.List;

import com.stefanini.estudo.model.Endereco;

public class StudentDTO {

	String nome;
	String matricula;
	Integer enderecoId;
	List<Integer> listaCursos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Integer getEnderecoId() {
		return enderecoId;
	}
	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public List<Integer> getListaCursos() {
		return listaCursos;
	}
	public void setListaCursos(List<Integer> listaCursos) {
		this.listaCursos = listaCursos;
	}
	
	
}


