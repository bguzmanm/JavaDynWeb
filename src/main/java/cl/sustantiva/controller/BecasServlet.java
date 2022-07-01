package cl.sustantiva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sustantiva.model.service.BecaService;

@WebServlet("/becas")
public class BecasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BecasServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BecaService bs = new BecaService();
		
		request.setAttribute("becas", bs.get());
		
		getServletContext().getRequestDispatcher("/view/becas.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
