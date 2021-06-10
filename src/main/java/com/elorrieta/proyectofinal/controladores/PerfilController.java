package com.elorrieta.proyectofinal.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.proyectofinal.dao.PerfilDAO;
import com.elorrieta.proyectofinal.modelo.Multimedia;
import com.elorrieta.proyectofinal.modelo.Usuario;

/**
 * Servlet implementation class PerfilController
 */
@WebServlet("/perfil")
public class PerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerfilController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recogemos el atributo guardado en el LoginController.
		HttpSession session = request.getSession();
		Usuario uLogeado = (Usuario) session.getAttribute("usuario_logeado");
		int idUsuario = uLogeado.getId();

		ArrayList<Multimedia> pelisValoradas = PerfilDAO.getMultimedia(idUsuario, 1);
		ArrayList<Multimedia> seriesValoradas = PerfilDAO.getMultimedia(idUsuario, 2);

		request.setAttribute("peliculas", pelisValoradas);
		request.setAttribute("series", seriesValoradas);

		request.getRequestDispatcher("perfil.jsp").forward(request, response);

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
