package com.stefanini.estudo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String matricula;
	
	
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	
	/*@ManyToMany
	private List<Curso> cursos = new ArrayList<>();
*/	
	/*@OneToOne(mappedBy="curso")
	private StudentCurso studentCurso;*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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

	public Student() {
		super();
	}

	





@Override
	public String toString() {
		return "Student [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", endereco=" + endereco + "]";
	}


public Student(Integer id, String nome, String matricula, Endereco endereco, StudentCurso studentCurso) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.endereco = endereco;
		//this.studentCurso = studentCurso;
	}


//
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", cursos=" + cursos + "]";
//	}


	/*public StudentCurso getStudentCurso() {
		return studentCurso;
	}
*/

	/*public void setStudentCurso(StudentCurso studentCurso) {
		this.studentCurso = studentCurso;
	}*/


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


//	public List<Curso> getCursos() {
//		return cursos;
//	}


//	public void setCursos(List<Curso> cursos) {
//		this.cursos = cursos;
//	}


	
	
	
	
}
