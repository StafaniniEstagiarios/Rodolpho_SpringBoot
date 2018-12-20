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
import javax.persistence.OneToOne;
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
	
/*	@OneToOne(mappedBy="curso")
	private StudentCurso studentCurso;
	*/
//	@JsonIgnore
//	@ManyToMany(mappedBy="cursos")
//	private List<Student> student;
	
	
	public Curso() {
		super();
	}
	

//	public List<Student> getStudent() {
//		return student;
//	}


//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}


	public Integer getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Curso [id=" + id + ", nomeDisciplina=" + nomeDisciplina + "]";
	}


	public Curso(Integer id, String nomeDisciplina, StudentCurso studentCurso) {
	super();
	this.id = id;
	this.nomeDisciplina = nomeDisciplina;
	//this.studentCurso = studentCurso;
}


/*	public StudentCurso getStudentCurso() {
		return studentCurso;
	}
*/

/*	public void setStudentCurso(StudentCurso studentCurso) {
		this.studentCurso = studentCurso;
	}*/


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
