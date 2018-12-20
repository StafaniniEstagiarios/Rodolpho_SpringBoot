package com.stefanini.estudo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentCursoChaveComposta implements Serializable{
	
	@Column(name="curso_id", nullable=false)
	private int curso_id;
	@Column(name="student_id", nullable=false)
	private int student_id;
	public int getCurso_id() {
		return curso_id;
	}
	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public StudentCursoChaveComposta(int curso_id, int student_id) {
		super();
		this.curso_id = curso_id;
		this.student_id = student_id;
	}
	public StudentCursoChaveComposta() {
		super();
	}
	
	
	
	
	

}
