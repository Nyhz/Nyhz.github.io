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
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Usuario> usuarios = UsuarioDAO.getAll();

		request.setAttribute("usuarios", usuarios);

		request.getRequestDispatcher("panelcontrol.jsp?page=usuarios").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String user_email = request.getParameter("user_email");

		try {

			Usuario u = new Usuario();

			u.setUser_name(user_name);
			u.setUser_password(user_password);
			u.setUser_email(user_email);

			request.setAttribute("usuarios", u);

			UsuarioDAO.insert(u);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("mensaje", "  Lo sentimos, usuario o email ya existe.");
			request.getRequestDispatcher("registro.jsp?page=registro").forward(request, response);
		}
	}
}
