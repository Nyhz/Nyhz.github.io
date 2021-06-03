package com.elorrieta.proyectofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.proyectofinal.connectionhelper.ConnectionHelper;
import com.elorrieta.proyectofinal.modelo.Multimedia;

public class MultimediaDAO {

	/**
	 * Retorna el top 10 de los multimedias seleccionados
	 * 
	 * @see Multimedia para ver los valores de los idTipo
	 * @param idTipo Tipo de Multimedia a obtener
	 * @return arrayList de Multimedia
	 */
	public static ArrayList<Multimedia> getTop(int idTipo) {
		ArrayList<Multimedia> coleccion = new ArrayList<Multimedia>();
		String sql = "SELECT id_multimedia, avg(puntuacion) as 'nota_media', multimedia.nombre as 'multimedia_nombre' FROM puntuaciones INNER JOIN multimedia ON puntuaciones.id_multimedia = multimedia.id WHERE id_tipo = ? GROUP BY id_multimedia  ORDER BY avg(puntuacion)  DESC LIMIT 10; ";
		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);

		) {

			pst.setInt(1, idTipo);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					Multimedia p = new Multimedia();

					p.setId(rs.getInt("id_multimedia"));
					p.setMultimediaNombre(rs.getString("multimedia_nombre"));
					p.setMultimediaNotaMedia(rs.getFloat("nota_media"));

					coleccion.add(p);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;
	}

}
