package com.elorrieta.proyectofinal.modelo;

public class Usuario {

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", user_name=" + user_name + ", user_password=" + user_password + ", user_email="
				+ user_email + ", user_avatar=" + user_avatar + ", rol=" + rol + ", fecha_creacion=" + fecha_creacion
				+ "]";
	}

	private int id;
	private String user_name;
	private String user_password;
	private String user_email;
	private String user_avatar;
	private int rol;
	private String fecha_creacion;

	public Usuario() {
		super();
		this.id = 0;
		this.user_name = "";
		this.user_password = "";
		this.user_email = "";
		this.user_avatar = "";
		this.rol = 0;
		this.fecha_creacion = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

}
