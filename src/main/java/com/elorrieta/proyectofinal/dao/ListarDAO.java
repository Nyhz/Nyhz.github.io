package com.elorrieta.proyectofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.proyectofinal.connectionhelper.ConnectionHelper;
import com.elorrieta.proyectofinal.modelo.Multimedia;

public class ListarDAO {

	public static ArrayList<Multimedia> listarMultimedia(int idTipo) {

		ArrayList<Multimedia> coleccion = new ArrayList<Multimedia>();
		String sql = "SELECT id, nombre FROM multimedia WHERE id_tipo = ? ORDER BY nombre DESC;";
		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);

		) {

			pst.setInt(1, idTipo);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					Multimedia p = new Multimedia();

					p.setId(rs.getInt("id"));
					p.setMultimediaNombre(rs.getString("nombre"));

					coleccion.add(p);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;
	}

}
