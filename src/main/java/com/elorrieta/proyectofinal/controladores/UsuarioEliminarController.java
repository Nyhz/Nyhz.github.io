package com.elorrieta.proyectofinal.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.proyectofinal.dao.UsuarioDAO;

/**
 * Servlet implementation class UsuarioEliminarController
 */
@WebServlet("/usuario-eliminar")
public class UsuarioEliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioEliminarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			UsuarioDAO.delete(id);

			request.setAttribute("mensajeTipo", "warning");
			request.setAttribute("mensaje", "Eliminado Participante");

		} catch (Exception e) {
			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "No se puede Eliminar");
			e.printStackTrace();
		}

		request.getRequestDispatcher("usuarios").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
