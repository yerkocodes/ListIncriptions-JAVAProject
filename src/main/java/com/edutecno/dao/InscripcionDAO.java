package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.InscripcionDTO;

public class InscripcionDAO {
	public List<InscripcionDTO> obtieneInscripciones() {
		List<InscripcionDTO> listaInscripciones = new ArrayList<InscripcionDTO>();
		
		Connection conn = null;

		try {
			
			// Clase del driver de conexion
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/edutecno?user=root&password=123321");
			
			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM inscripcion");
			ResultSet rs = pstm.executeQuery();
			
			while( rs.next() ) {
				InscripcionDTO inscripcion = new InscripcionDTO();
				inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
				inscripcion.setNombre(rs.getString("nombre"));
				inscripcion.setTelefono(rs.getString("telefono"));
				inscripcion.setId_curso(rs.getInt("id_curso"));
				inscripcion.setId_forma_pago(rs.getInt("id_forma_pago"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return listaInscripciones;
	}
}
