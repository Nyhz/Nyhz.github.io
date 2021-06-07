package com.elorrieta.proyectofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.elorrieta.proyectofinal.connectionhelper.ConnectionHelper;
import com.elorrieta.proyectofinal.modelo.Usuario;

public class LoginDAO {

	/**
	 * Buscamos un usuario por su nombre y password
	 * 
	 * @param nombre
	 * @param pass
	 * @return usuario con datos si lo encuentra, null si no encuentra
	 */
	public static Usuario login(String nombre, String pass) {

		Usuario usuario = null;
		String sql = "SELECT id, user_name, user_password, user_email, user_avatar, rol, fecha_creacion FROM usuarios WHERE user_name = ? AND user_password = ?;";

		try {
			Connection con = ConnectionHelper.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, nombre);
			pst.setString(2, pass);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					usuario = new Usuario();

					usuario.setId(rs.getInt("id"));
					usuario.setUser_name(rs.getString("user_name"));
					usuario.setUser_password(rs.getString("user_password"));
					usuario.setUser_email(rs.getString("user_email"));
					usuario.setUser_avatar(rs.getString("user_avatar"));
					usuario.setRol(rs.getInt("rol"));
					usuario.setFecha_creacion(rs.getString("fecha_creacion"));

				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}