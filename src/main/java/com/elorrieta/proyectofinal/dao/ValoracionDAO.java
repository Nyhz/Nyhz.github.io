package com.elorrieta.proyectofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.elorrieta.proyectofinal.connectionhelper.ConnectionHelper;
import com.elorrieta.proyectofinal.modelo.Valoracion;

public class ValoracionDAO {

	public static Valoracion getValoracion(int idMulti, int idUsuario) throws Exception {
		Valoracion valoracion = new Valoracion();

		String sql = "SELECT id_multimedia, id_usuario, puntuacion,comentario, nombre FROM puntuaciones, multimedia WHERE puntuaciones.id_multimedia = multimedia.id AND id_usuario = ? AND id_multimedia = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, idUsuario);
			pst.setInt(2, idMulti);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					valoracion.setId_usuario(rs.getInt("id_usuario"));
					valoracion.setId_multimedia(rs.getInt("id_multimedia"));
					valoracion.setPuntuacion(rs.getInt("puntuacion"));
					valoracion.setNombre(rs.getString("nombre"));
					// TODO comentario

				}

			}

		}
		return valoracion;
	}

	public static boolean update(Valoracion v) throws Exception {
		boolean modificado = false;

		String sql = "UPDATE puntuaciones SET puntuacion = ? WHERE id_multimedia = ? and id_usuario = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, v.getPuntuacion());
			pst.setInt(2, v.getId_multimedia());
			pst.setInt(3, v.getId_usuario());

			if (pst.executeUpdate() == 1) {
				modificado = true;
			}
		}
		return modificado;
	}

	public static boolean insert(Valoracion v) throws Exception {
		boolean insertado = false;

		String sql = "INSERT INTO puntuaciones VALUES (?,?,?,?);";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, v.getId_multimedia());
			pst.setInt(2, v.getId_usuario());
			pst.setInt(3, v.getPuntuacion());
			pst.setString(4, v.getComentario());

			if (pst.executeUpdate() == 1) {
				insertado = true;
			}
		}
		return insertado;
	}
}
