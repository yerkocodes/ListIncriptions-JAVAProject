package com.edutecno.service;

import java.sql.SQLException;
import java.util.List;

import com.edutecno.dao.CursoDAO;
import com.edutecno.dao.FormaDePagoDAO;
import com.edutecno.model.CursoDTO;
import com.edutecno.model.FormaDePagoDTO;

public class Facade {

	// Metodo encargado de comunicarse con el cursoDAO y acceder a los cursos
	public List<CursoDTO> obtieneCursos() throws SQLException {
		CursoDAO cursoDAO = new CursoDAO(); // Instancia para acceder al data access object DAO
		return cursoDAO.obtieneCursos();
	}

	// Metodo encargado de comunicarse con el FormaDePagoDAO y acceder a las formas de pago
	public List<FormaDePagoDTO> obtieneFormasDePago() throws SQLException {
		FormaDePagoDAO formaDePagoDAO = new FormaDePagoDAO();
		return formaDePagoDAO.obtieneFormaDePago();
	}
}
