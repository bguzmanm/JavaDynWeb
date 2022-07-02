package cl.sustantiva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sustantiva.model.service.CityService;


@WebServlet("/city")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CityServlet() {
        super();

    }

    CityService cs = new CityService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("citys", cs.read());
		
		getServletContext().getRequestDispatcher("/view/citys.jsp").forward(request, response);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
