package cl.sustantiva.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.sustantiva.model.entity.Postulante;
import cl.sustantiva.model.service.PostulanteService;


@WebServlet("/postulantes")
public class PostulanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostulanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = (HttpSession)request.getSession();
		
		//Si no existe la variable sesión, la creo y le pongo los datos por defecto
		if (session.getAttribute("listaPostulantes")==null) {
			System.out.println("Creo variable de sesión -> /postulante");
			
			PostulanteService ps = new PostulanteService();
			request.setAttribute("postulantes", ps.get());
		} else {
			//si existe la variable de sesión, entonces, la leo
			List<Postulante> lista = (List<Postulante>)session.getAttribute("listaPostulantes");
			request.setAttribute("postulantes", lista);
		}
		
		
		getServletContext().getRequestDispatcher("/view/postulantes.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
