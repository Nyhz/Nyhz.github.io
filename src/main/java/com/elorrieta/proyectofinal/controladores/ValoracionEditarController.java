package com.elorrieta.proyectofinal.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.proyectofinal.dao.ValoracionDAO;
import com.elorrieta.proyectofinal.modelo.Usuario;
import com.elorrieta.proyectofinal.modelo.Valoracion;

/**
 * Servlet implementation class ValoracionEditarController
 */
@WebServlet("/valoracion-editar")
public class ValoracionEditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValoracionEditarController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int idMultimedia = Integer.parseInt(request.getParameter("id_multimedia"));

			HttpSession session = request.getSession();
			Usuario u = (Usuario) session.getAttribute("usuario_logeado");

			Valoracion v = ValoracionDAO.getValoracion(idMultimedia, u.getId());

			request.setAttribute("valoracion", v);
			request.getRequestDispatcher("valorar.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id_multimedia = Integer.parseInt(request.getParameter("id_multimedia"));
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario_logeado");

		int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
		String comentario = (request.getParameter("comentario"));

		Valoracion v = new Valoracion();
		v.setId_multimedia(id_multimedia);
		v.setId_usuario(u.getId());
		v.setPuntuacion(puntuacion);
		v.setComentario(comentario);

		try {
			ValoracionDAO.update(v);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// NOS QUEDAMOS EN EL PEFIL

		request.setAttribute("valoracion", v);
		request.getRequestDispatcher("perfil").forward(request, response);

	}

}
