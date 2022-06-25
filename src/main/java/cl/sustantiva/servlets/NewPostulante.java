package cl.sustantiva.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sustantiva.model.Postulante;
import cl.sustantiva.service.PostulanteService;

@WebServlet("/postulantes/new")
public class NewPostulante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PostulanteService ps = new PostulanteService();
	
    public NewPostulante() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/view/postulante.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int edad = Integer.parseInt(request.getParameter("edad"));
		float nota = Float.parseFloat(request.getParameter("nota"));
		
		
		ps.add(new Postulante(0, nombre, apellido, edad, nota));
		
		getServletContext().getRequestDispatcher("/postulantes").forward(request, response);
		
	}

}
