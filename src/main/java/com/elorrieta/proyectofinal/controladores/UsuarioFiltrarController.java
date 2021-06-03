package com.elorrieta.proyectofinal.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.proyectofinal.dao.UsuarioDAO;
import com.elorrieta.proyectofinal.modelo.Usuario;

/**
 * Servlet implementation class UsuarioFiltrarController
 */
@WebServlet("/usuario-filtrar")
public class UsuarioFiltrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioFiltrarController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filtro = request.getParameter("filtro");
		String mensaje = "";
		ArrayList<Usuario> lista1 = UsuarioDAO.getAllByName(filtro);
		if (filtro != null) {

			// enviar atributos para pintar
			request.setAttribute("usuarios", lista1);
			request.setAttribute(mensaje, "Has buscado " + filtro + "");
			request.setAttribute("filtro", filtro);

			// ir a la vista
			request.getRequestDispatcher("panelcontrol.jsp?page=usuarios").forward(request, response);

		} else {

			ArrayList<Usuario> lista2 = UsuarioDAO.getAll();

			// enviar atributos para pintar
			request.setAttribute("participantes", lista2);

			// ir a la vista
			request.getRequestDispatcher("panelcontrol.jsp").forward(request, response);
		}
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
