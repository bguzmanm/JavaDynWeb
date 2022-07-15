package cl.sustantiva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InicioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Manejo de Cookies
		Cookie chocolate = new Cookie("nombre", "Brian");
		chocolate.setMaxAge(60);
		response.addCookie(chocolate);
				
		getServletContext().getRequestDispatcher("/view/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
