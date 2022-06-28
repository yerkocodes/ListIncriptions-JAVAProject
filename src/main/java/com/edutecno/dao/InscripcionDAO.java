package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.InscripcionDTO;

public class InscripcionDAO {
	public List<InscripcionDTO> obtieneInscripciones() throws SQLException {
		List<InscripcionDTO> listaInscripciones = new ArrayList<InscripcionDTO>();

		Connection conn = null;

		try {

			// Clase del driver de conexion
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost/listarinscripciones?user=root&password=123321");

			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM inscripcion");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				InscripcionDTO inscripcion = new InscripcionDTO();
				inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
				inscripcion.setNombre(rs.getString("nombre"));
				inscripcion.setTelefono(rs.getString("telefono"));
				inscripcion.setId_curso(rs.getInt("id_curso"));
				inscripcion.setId_forma_pago(rs.getInt("id_forma_pago"));

				listaInscripciones.add(inscripcion);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return listaInscripciones;
	}

	// Metodo para insertar una nueva inscripcion en la base de datos
	public InscripcionDTO insertarInscripcion(InscripcionDTO inscripcionDTO) throws SQLException {

		Connection conn = null;

		try {
			// INSERT INTO inscripcion (nombre, telefono, id_curso, id_forma_pago) VALUES (?, ?, ?, ?);

			// Clase del driver de conexion
			Class.forName("com.mysql.cj.jdbc.Driver");

			// "jdbc:mysql://localhost/DATABASENAME?user=USERNAME&password=MYPASSWORD"
			conn = DriverManager.getConnection("jdbc:mysql://localhost/listarinscripciones?user=root&password=123321");

			PreparedStatement pstm = conn.prepareStatement("INSERT INTO inscripcion (nombre, telefono, id_curso, id_forma_pago) VALUES (?, ?, ?, ?)");
			pstm.setString(1, inscripcionDTO.getNombre());
			pstm.setString(2, inscripcionDTO.getTelefono());
			pstm.setInt(3, inscripcionDTO.getId_curso());
			pstm.setInt(4, inscripcionDTO.getId_forma_pago());
			
			int statusQueryExecuted = pstm.executeUpdate(); // Si la querie se ejecuta sin problemas retornara 1 de lo contrario 0
			
			if ( statusQueryExecuted == 1 ) {
				
				PreparedStatement pstm2 = conn.prepareStatement("SELECT MAX(id_inscripcion) FROM inscripcion"); // Con esta querie obtenemos el id_inscripcion del ultimo elemento insertado para poder setearlo en el objeto entregado al metodo
				ResultSet rs = pstm2.executeQuery();
				
				if (rs.next()) {
					inscripcionDTO.setId_inscripcion(rs.getInt(1));
				}

			} else {
				throw new RuntimeException("Ha ocurrido un error insertando la inscripcion");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return inscripcionDTO;

	}
}
