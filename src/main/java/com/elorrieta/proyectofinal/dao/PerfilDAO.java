package com.elorrieta.proyectofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.proyectofinal.connectionhelper.ConnectionHelper;
import com.elorrieta.proyectofinal.modelo.Multimedia;

public class PerfilDAO {

	/**
	 * Retorna las peliculas/series valoradas de un usuario concreto.
	 * 
	 * @see Multimedia para ver los valores de los idTipo
	 * @param idTipo Tipo de Multimedia a obtener
	 * @return arrayList de Multimedia
	 */
	public static ArrayList<Multimedia> getMultimedia(int idUsuario, int idTipo) {

		ArrayList<Multimedia> coleccion = new ArrayList<Multimedia>();
		String sql = "SELECT multimedia.nombre as 'nombre', puntuacion FROM puntuaciones INNER JOIN multimedia ON puntuaciones.id_multimedia = multimedia.id WHERE id_usuario = ? and id_tipo = ? ORDER BY puntuacion  DESC LIMIT 10; ";
		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);

		) {

			pst.setInt(1, idUsuario);
			pst.setInt(2, idTipo);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					Multimedia p = new Multimedia();

					p.setMultimediaNombre(rs.getString("nombre"));
					p.setMultimediaNotaMedia(rs.getInt("puntuacion"));

					coleccion.add(p);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;
	}

}