package cl.sustantiva.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sustantiva.model.entity.Country;
import cl.sustantiva.model.service.CountryService;


@WebServlet("/country")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CountryServlet() {
        super();
    }

    CountryService cs = new CountryService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = request.getParameter("id");
		String op = request.getParameter("op");
		
		System.out.println("ID: " + id);
		
		if (id == null) {
			
			if (Objects.nonNull(op)) {
				if (op.equalsIgnoreCase("new")) {
					getServletContext().getRequestDispatcher("/view/country.jsp").forward(request, response);
				} else {
					request.setAttribute("countrys", cs.read());			
					getServletContext().getRequestDispatcher("/view/countrys.jsp").forward(request, response);
				}			
			} else {
				request.setAttribute("countrys", cs.read());			
				getServletContext().getRequestDispatcher("/view/countrys.jsp").forward(request, response);
			}
				
		} else {
			if (op == null) {
				request.setAttribute("country", cs.read(Integer.parseInt(id)));
				request.setAttribute("titulo", "Edición del país");
				getServletContext().getRequestDispatcher("/view/country.jsp").forward(request, response);
			} else {

				cs.delete(Integer.parseInt(id));
				
				request.setAttribute("countrys", cs.read());			
				getServletContext().getRequestDispatcher("/view/countrys.jsp").forward(request, response);
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("country_id");
		String nombre = request.getParameter("country");
		
		System.out.println("ID: " + id.trim());
		System.out.println("NO: " + nombre);
		
		if (id == null || Objects.isNull(id) || "".equals(id)) {
			id = "0";
		}
		
		//" hola, como estás? " => trim -> "hola, como estás?" 
		//" hola, como estás? " => ltrim -> "hola, como estás? " 
		//" hola, como estás? " => rtrim -> " hola, como estás?" 
		
		Country country = new Country(Integer.parseInt(id), nombre);
		
		cs.create(country);
		
		request.setAttribute("countrys", cs.read());		
		getServletContext().getRequestDispatcher("/view/countrys.jsp").forward(request, response);
		
		
		
	}

}
