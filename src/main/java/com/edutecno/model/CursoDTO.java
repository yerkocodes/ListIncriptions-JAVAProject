package com.edutecno.model;

public class CursoDTO {
	private int id_curso;
	private String descripcion;
	private int precio;

	// Empty constructor
	public CursoDTO() {}

	// Constructor with parameters
	public CursoDTO(int id_curso, String descripcion, int precio) {
		super();
		this.id_curso = id_curso;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	// Getters and Setters
	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "CursoDTO [id_curso=" + id_curso + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
}
