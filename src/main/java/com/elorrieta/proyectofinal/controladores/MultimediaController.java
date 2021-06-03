package com.elorrieta.proyectofinal.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.proyectofinal.dao.MultimediaDAO;
import com.elorrieta.proyectofinal.modelo.Multimedia;

/**
 * Servlet implementation class MultimediaController
 */
@WebServlet("/index")
public class MultimediaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MultimediaController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Multimedia> topPeliculas = MultimediaDAO.getTop(Multimedia.PELICULAS);
		ArrayList<Multimedia> topSeries = MultimediaDAO.getTop(Multimedia.SERIES);

		request.setAttribute("peliculas", topPeliculas);
		request.setAttribute("series", topSeries);

		request.getRequestDispatcher("index.jsp?page=index").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
