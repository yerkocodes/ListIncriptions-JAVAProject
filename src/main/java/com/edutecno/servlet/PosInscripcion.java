package com.edutecno.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.model.InscripcionDTO;
import com.edutecno.service.Facade;

/**
 * Servlet implementation class PosInscripcion
 * Responsabilidad de recibir los datos del formulario de inscripcion
 * Asignar los datos a un objeto inscripcionDTO, invocar el facade y llamar al DAO insertando la inscripcion en la base de datos
 */
@WebServlet("/posInscripcion")
public class PosInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// obtenemos los datos enviados mediante el request.getParameter()
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		int idFormaPago = Integer.parseInt(request.getParameter("idFormaPago"));
		
		InscripcionDTO inscripcionDTO = new InscripcionDTO();
		inscripcionDTO.setNombre(nombre);
		inscripcionDTO.setTelefono(telefono);
		inscripcionDTO.setId_curso(idCurso);
		inscripcionDTO.setId_forma_pago(idFormaPago);
		
		Facade facade = new Facade();
		
		try {
			InscripcionDTO inscripcionRegistrada = facade.insertarInscripciones(inscripcionDTO);
			
			request.setAttribute("inscripcion", inscripcionRegistrada);
			request.getRequestDispatcher("preConfirmacion").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
