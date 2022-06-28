package com.edutecno.model;

public class FormaDePagoDTO {
	private String id_forma_pago;
	private String descripcion;
	private String recargo;
	
	// Empty constructor
	public FormaDePagoDTO() {}

	// Constructor with parameters
	public FormaDePagoDTO(String id_forma_pago, String descripcion, String recargo) {
		super();
		this.id_forma_pago = id_forma_pago;
		this.descripcion = descripcion;
		this.recargo = recargo;
	}

	// Getters and Setters
	public String getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(String id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRecargo() {
		return recargo;
	}

	public void setRecargo(String recargo) {
		this.recargo = recargo;
	}

	@Override
	public String toString() {
		return "FormaDePagoDTO [id_forma_pago=" + id_forma_pago + ", descripcion=" + descripcion + ", recargo="
				+ recargo + "]";
	}
	
}
