package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.CursoDTO;

public class CursoDAO {
	// List<CursoDTO> findAll()
	// CursoDTO findById(int id)
	// CursoDTO add(CursoDTO cursoDTO) / boolean save(CursoDTO cursoDTO)
	// CursoDTO update(CursoDTO cursoDTO) / boolean update(CursoDTO cursoDTO)
	// boolean delete(int id) / int delete(CursoDTO cursoDTO)

	// Metodo para obtener todos los cursos existentes en la base de datos.
	public List<CursoDTO> obtieneCursos() throws SQLException {
		// Lista para almacenar los cursos obtenidos de la consulta
		List<CursoDTO> listaCursos = new ArrayList<CursoDTO>();

		Connection conn = null;

		try {

			// Clase del driver de conexion
			Class.forName("com.mysql.cj.jdbc.Driver");

			// "jdbc:mysql://localhost/DATABASENAME?user=USERNAME&password=MYPASSWORD"
			conn = DriverManager.getConnection("jdbc:mysql://localhost/listarinscripciones?user=root&password=123321");
			
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM curso");
			ResultSet rs = pstm.executeQuery(); // Se utiliza para los SELECT
			
			while ( rs.next() ) {
				CursoDTO curso = new CursoDTO();
				curso.setId_curso(rs.getInt("id_curso"));
				curso.setDescripcion(rs.getString("descripcion"));
				curso.setPrecio(rs.getInt("precio"));
				
				listaCursos.add(curso);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return listaCursos;
	}
}
