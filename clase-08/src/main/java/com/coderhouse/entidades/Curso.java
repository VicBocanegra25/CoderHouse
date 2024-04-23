package com.coderhouse.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Una nueva entidad que relacionaremos con la clase Alumno
@Entity
@Table(name="cursos")
public class Curso {

		@Id
		@Column(name="id_curso")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer idCurso;
		@Column(name="titulo")
		private String titulo;
		@Column(name="descripcion")
		private String descripcion;

		// La relación entre Alumno y Curso es OneToMany
		@OneToMany(mappedBy="curso")
		private List<Alumno> alumnos;
		
		
		public Curso() {
			
		}


		public Integer getIdCurso() {
			return idCurso;
		}


		public void setIdCurso(Integer idCurso) {
			this.idCurso = idCurso;
		}


		public String getTitulo() {
			return titulo;
		}


		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		
		
}
