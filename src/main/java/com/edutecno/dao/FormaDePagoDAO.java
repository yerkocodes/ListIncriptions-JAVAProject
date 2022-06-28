package com.edutecno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.FormaDePagoDTO;

public class FormaDePagoDAO {
	public List<FormaDePagoDTO> obtieneFormaDePago() throws SQLException {
		List<FormaDePagoDTO> listaFormasDePago = new ArrayList<FormaDePagoDTO>();

		Connection conn = null;

		try {

			// Clase del driver de conexion
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost/edutecno?user=root&password=123321");

			PreparedStatement pstm = conn.prepareStatement("SELECT * FROM forma_pago");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				FormaDePagoDTO formaDePago = new FormaDePagoDTO();
				formaDePago.setId_forma_pago(rs.getString("id_forma_pago"));
				formaDePago.setDescripcion(rs.getString("descripcion"));
				formaDePago.setRecargo(rs.getString("recargo"));
				
				listaFormasDePago.add(formaDePago);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return listaFormasDePago;

	}
}
