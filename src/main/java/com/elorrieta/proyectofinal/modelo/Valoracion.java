package com.elorrieta.proyectofinal.modelo;

public class Valoracion {

	private int id_usuario;
	private int id_multimedia;
	private int puntuacion;
	private String comentario;
	private String nombre;

	public Valoracion() {
		super();
		this.id_usuario = 0;
		this.id_multimedia = 0;
		this.puntuacion = 0;
		this.comentario = "";
		this.nombre = "";
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_multimedia() {
		return id_multimedia;
	}

	public void setId_multimedia(int id_multimedia) {
		this.id_multimedia = id_multimedia;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Valoracion [id_usuario=" + id_usuario + ", id_multimedia=" + id_multimedia + ", puntuacion="
				+ puntuacion + ", comentario=" + comentario + ", nombre=" + nombre + "]";
	}

}
