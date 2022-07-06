package cl.sustantiva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sustantiva.model.entity.City;
import cl.sustantiva.model.service.CityService;
import cl.sustantiva.model.service.CountryService;

@WebServlet("/city")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CityServlet() {
		super();

	}

	CityService cs = new CityService();
	CountryService cos = new CountryService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		String id = request.getParameter("id");

		if (op != null) {
			if (op.equalsIgnoreCase("del")) {
				cs.delete(Integer.parseInt(id));
				request.setAttribute("citys", cs.read());
				getServletContext().getRequestDispatcher("/view/citys.jsp").forward(request, response);
			} else {
				request.setAttribute("countrys", cos.read());
				if (op.equalsIgnoreCase("edit")) {
					request.setAttribute("city", cs.read(Integer.parseInt(id)));
					request.setAttribute("titulo", "Edición de Ciudad");
				} else {
					request.setAttribute("titulo", "Crear nueva Ciudad");
				}
				getServletContext().getRequestDispatcher("/view/city.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("citys", cs.read());
			getServletContext().getRequestDispatcher("/view/citys.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");

		if (op != null) {
			String id = request.getParameter("city_id");
			String nombre = request.getParameter("city");
			String country_id = request.getParameter("country");
			

			if (op.equalsIgnoreCase("edit")) {
				cs.update(new City(Integer.parseInt(id), nombre, Integer.parseInt(country_id)));
			} else {
				cs.create(new City(0, nombre, Integer.parseInt(country_id)));
			}
		}

		request.setAttribute("citys", cs.read());
		getServletContext().getRequestDispatcher("/view/citys.jsp").forward(request, response);

	}

}
