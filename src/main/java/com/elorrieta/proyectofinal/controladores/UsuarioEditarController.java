package com.elorrieta.proyectofinal.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.proyectofinal.dao.UsuarioDAO;
import com.elorrieta.proyectofinal.modelo.Usuario;

/**
 * Servlet implementation class UsuarioEditarController
 */
@WebServlet("/usuario-editar")
public class UsuarioEditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioEditarController() {
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

		Usuario u = new Usuario();
		String titulo = "Crear Nuevo Usuario";

		if (id > 0) {
			titulo = "Modificar Usuario";
			u = UsuarioDAO.getById(id);
		}

		request.setAttribute("titulo", titulo);
		request.setAttribute("usuarios", u);
		request.getRequestDispatcher("registro.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		String avatar = request.getParameter("user_avatar");
		int rol = Integer.parseInt(request.getParameter("rol"));

		Usuario u = new Usuario();
		u.setId(id);
		u.setUser_name(nombre);
		u.setUser_password(password);
		u.setUser_email(email);
		u.setUser_avatar(avatar);
		u.setRol(rol);

		try {
			if (id == 0) {
				UsuarioDAO.insert(u);
			} else {
				UsuarioDAO.update(u);
			}

			request.setAttribute("mensajeTipo", "primary");
			request.setAttribute("mensaje", "Datos Guardados");

		} catch (Exception e) {
			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "El email esta repetido");

		}

		request.setAttribute("titulo", "Modificar Participante");
		request.setAttribute("usuarios", u);
		request.getRequestDispatcher("usuarios?page=usuarios").forward(request, response);

	}

}
