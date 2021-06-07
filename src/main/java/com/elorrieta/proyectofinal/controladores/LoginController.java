package com.elorrieta.proyectofinal.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elorrieta.proyectofinal.dao.LoginDAO;
import com.elorrieta.proyectofinal.modelo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger PARAMETROS, CUIDADO siempre son String
		String nombreLogin = request.getParameter("user_name");
		String passLogin = request.getParameter("user_password");

		// Llamar al DAO
		Usuario u = LoginDAO.login(nombreLogin, passLogin);

		if (u != null) {

			HttpSession session = request.getSession();
			session.setAttribute("usuario_logeado", u);
			session.setMaxInactiveInterval(300); // 5 min

			request.setAttribute("nombreusuario", nombreLogin);
			request.getRequestDispatcher("perfil.jsp").forward(request, response);

		} else {

			request.setAttribute("mensajelogin", "Por favor vuelva a intentarlo");
			request.getRequestDispatcher("index").forward(request, response);
		}
	}
}
