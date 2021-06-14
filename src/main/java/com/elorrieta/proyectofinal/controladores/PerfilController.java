package com.elorrieta.proyectofinal.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.proyectofinal.dao.ListarDAO;
import com.elorrieta.proyectofinal.dao.PerfilDAO;
import com.elorrieta.proyectofinal.dao.ValoracionDAO;
import com.elorrieta.proyectofinal.modelo.Multimedia;
import com.elorrieta.proyectofinal.modelo.Usuario;
import com.elorrieta.proyectofinal.modelo.Valoracion;

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

		ArrayList<Multimedia> listaPeliculas = ListarDAO.listarMultimedia(1);
		ArrayList<Multimedia> listaSeries = ListarDAO.listarMultimedia(2);

		request.setAttribute("listapeliculas", listaPeliculas);
		request.setAttribute("listaseries", listaSeries);

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
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario_logeado");

		int idMultimedia = Integer.parseInt(request.getParameter("id"));
		int idUsuario = u.getId();
		int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
		String comentario = request.getParameter("comentario");

		Valoracion v = new Valoracion();
		v.setId_multimedia(idMultimedia);
		v.setId_usuario(idUsuario);
		v.setPuntuacion(puntuacion);
		v.setComentario(comentario);

		try {
			ValoracionDAO.insert(v);

			// LISTADO DE USUARIOS
			request.setAttribute("mensajeTipo", "primary");
			request.setAttribute("mensaje", "Valoracion insertada");
			request.getRequestDispatcher("/index").forward(request, response);

		} catch (

		Exception e) {

			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "ERROR! Valoracion NO insertada");
			request.getRequestDispatcher("/index").forward(request, response);

		}
	}
}
