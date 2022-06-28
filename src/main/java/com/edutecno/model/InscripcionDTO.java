package com.edutecno.model;

public class InscripcionDTO {
	private int id_inscripcion;
	private String nombre;
	private String telefono;
	private int id_curso;
	private int id_forma_pago;
	
	// Empty constructor
	public InscripcionDTO() {}

	// Constructor with parameters
	public InscripcionDTO(int id_inscripcion, String nombre, String telefono, int id_curso, int id_forma_pago) {
		super();
		this.id_inscripcion = id_inscripcion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.id_curso = id_curso;
		this.id_forma_pago = id_forma_pago;
	}

	// Getters and Setters
	public int getId_inscripcion() {
		return id_inscripcion;
	}

	public void setId_inscripcion(int id_inscripcion) {
		this.id_inscripcion = id_inscripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public int getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(int id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	@Override
	public String toString() {
		return "InscripcionDTO [id_inscripcion=" + id_inscripcion + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", id_curso=" + id_curso + ", id_forma_pago=" + id_forma_pago + "]";
	}
	
}
