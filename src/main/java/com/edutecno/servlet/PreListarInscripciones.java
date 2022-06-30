package com.edutecno.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.model.InscripcionDTO;
import com.edutecno.service.Facade;

/**
 * Servlet implementation class PreListarInscripciones
 * Responsabilidad de consultar por todas las inscripciones existentes en la base de datos
 */
@WebServlet("/preListarInscripciones")
public class PreListarInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instanciamos el facade y accedemos a el data access object InscripcionDAO
		Facade facade = new Facade();
		
		try {
			// Se obtiene la lista de inscripciones consultada
			List<InscripcionDTO> inscripciones = facade.obtieneInscripciones();
			
			request.setAttribute("listaInscripciones", inscripciones);
			
			request.getRequestDispatcher("listaInscripciones.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
