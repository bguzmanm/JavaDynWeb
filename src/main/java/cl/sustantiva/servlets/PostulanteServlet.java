package cl.sustantiva.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sustantiva.service.PostulanteService;


@WebServlet("/postulantes")
public class PostulanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostulanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PostulanteService ps = new PostulanteService();
		
		request.setAttribute("postulantes", ps.get());
		getServletContext().getRequestDispatcher("/view/postulantes.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
