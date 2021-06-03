package com.elorrieta.proyectofinal.modelo;

/**
 * 
 * @author cursos_externos
 *
 */
public class Multimedia {

	public static final int PELICULAS = 1;
	public static final int SERIES = 2;

	private int id;
	private String multimediaNombre;
	private float multimediaNotaMedia;

	public Multimedia() {
		super();
		this.id = 0;
		this.multimediaNombre = "";
		this.multimediaNotaMedia = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMultimediaNombre() {
		return multimediaNombre;
	}

	public void setMultimediaNombre(String multimediaNombre) {
		this.multimediaNombre = multimediaNombre;
	}

	public float getMultimediaNotaMedia() {
		return multimediaNotaMedia;
	}

	public void setMultimediaNotaMedia(float multimediaNotaMedia) {
		this.multimediaNotaMedia = multimediaNotaMedia;
	}

}