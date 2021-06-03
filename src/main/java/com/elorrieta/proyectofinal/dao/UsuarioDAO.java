package com.elorrieta.proyectofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.proyectofinal.connectionhelper.ConnectionHelper;
import com.elorrieta.proyectofinal.modelo.Usuario;

public class UsuarioDAO {

	public static ArrayList<Usuario> getAll() {

		ArrayList<Usuario> coleccion = new ArrayList<Usuario>();
		String sql = "SELECT id, user_name, user_email, user_avatar, rol, fecha_creacion FROM usuarios ORDER BY id ASC; ";

		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				// creamos un nuevo Objeto y lo seteamos con los valores del RS
				Usuario u = new Usuario();

				u.setId(rs.getInt("id"));
				u.setUser_name(rs.getString("user_name"));
				u.setUser_email(rs.getString("user_email"));
				u.setUser_avatar(rs.getString("user_avatar"));
				u.setRol(rs.getInt("rol"));
				u.setFecha_creacion(rs.getString("fecha_creacion"));

				// a�adir objeto al ArrayList
				coleccion.add(u);

			}
			// fin del bucle, ya no quedan mas lineas para leer

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;
	}

	public static boolean insert(Usuario uNuevo) throws Exception {

		boolean resultado = false;
		String sql = "INSERT INTO usuarios ( user_name, user_email, user_password ) VALUES (?,?,?);";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			// sustituir ? por valores del pNuevo
			pst.setString(1, uNuevo.getUser_name());
			pst.setString(2, uNuevo.getUser_email());
			pst.setString(3, uNuevo.getUser_password());

			// ejecuta la INSERT
			int affectedRows = pst.executeUpdate();
			// comprobamos que se ha insertado una fila
			if (affectedRows == 1) {
				resultado = true;
			}
		}

		return resultado;
	}

	public static ArrayList<Usuario> getAllByName(String filtro) {

		ArrayList<Usuario> coleccion = new ArrayList<Usuario>();
		String sql = "SELECT id, user_name, user_email, user_avatar, rol, fecha_creacion FROM usuarios WHERE user_name LIKE ? or user_email LIKE ? ;";

		try {
			Connection con = ConnectionHelper.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, "%" + filtro + "%");
			pst.setString(2, "%" + filtro + "%");

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					Usuario u = new Usuario();

					u.setId(rs.getInt("id"));
					u.setUser_name(rs.getString("user_name"));
					u.setUser_email(rs.getString("user_email"));
					u.setUser_avatar(rs.getString("user_avatar"));
					u.setRol(rs.getInt("rol"));
					u.setFecha_creacion(rs.getString("fecha_creacion"));

					coleccion.add(u);
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return coleccion;
	}

}
