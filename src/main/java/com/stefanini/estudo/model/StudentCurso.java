package com.stefanini.estudo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity

public class StudentCurso {

	@EmbeddedId
	private StudentCursoChaveComposta id;
	
	@OneToOne
	@JoinColumn(name="student_id", insertable=false, updatable= false)
	private Student student;
	
	@OneToOne
	@JoinColumn(name="curso_id", insertable=false, updatable=false)
	private Curso curso;

	public StudentCurso(Student student, Curso curso) {
		this.student = student;
		this.curso = curso;
		id = new StudentCursoChaveComposta(this.curso.getId(), this.student.getId());
	}
	
	public StudentCursoChaveComposta getId() {
		return id;
	}

	public void setId(StudentCursoChaveComposta id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public StudentCurso(StudentCursoChaveComposta id) {
		this.id = id;
	}

	public StudentCurso() {
		super();
	}
	
	
}
