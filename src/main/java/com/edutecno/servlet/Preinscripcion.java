package com.edutecno.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.model.CursoDTO;
import com.edutecno.model.FormaDePagoDTO;
import com.edutecno.service.Facade;

/**
 * Servlet implementation class Preinscripcion responsabilidad de obtener los
 * cursos y las formas de pago para enviarlas a la vista
 */
@WebServlet("/preinscripcion")
public class Preinscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Preinscripcion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Facade facade = new Facade();

		try {
			//se obtiene la lista de cursos
			List<CursoDTO> listaCursos = facade.obtieneCursos();
			
			//se obtiene la lista de formas de pago
			List<FormaDePagoDTO> listaFormasDePago = facade.obtieneFormasDePago();
			
			//setear los datos en el request para despacharlos a la vista mediante request
			request.setAttribute("listaCursos", listaCursos);
			request.setAttribute("listaFormasPago", listaFormasDePago);
			
			//despachar hacia la vista o sevlet que procesara los datos
			request.getRequestDispatcher("inscripcion.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
