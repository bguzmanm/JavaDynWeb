package cl.sustantiva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sustantiva.model.dao.CityDAO;
import cl.sustantiva.model.dao.CountryDAO;
import cl.sustantiva.model.entity.Address;
import cl.sustantiva.model.entity.City;
import cl.sustantiva.model.service.AddressService;

@WebServlet("/address")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddressServlet() {
        super();
    }
    
    AddressService as = new AddressService();
    CityDAO ciDAO = new CityDAO();
    CountryDAO coDAO = new CountryDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		
		if (op != null) {
			if (op.equalsIgnoreCase("edit")) {
				Address a = as.read(Integer.parseInt(id));
				request.setAttribute("address", a);
				request.setAttribute("countrys", coDAO.read());
				request.setAttribute("citys", ciDAO.readOrderByCountry());
				
				
				request.setAttribute("titulo", "Editar Dirección");
				getServletContext().getRequestDispatcher("/view/direction.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("address", as.read());
			getServletContext().getRequestDispatcher("/view/address.jsp").forward(request, response);	
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String op = request.getParameter("op");
		
		System.out.println(op);
		
		if (op != null) {
			if (op.equalsIgnoreCase("edit")) {
				String address_id = request.getParameter("address_id");
				String address = request.getParameter("address");
				String address2 = request.getParameter("address2");
				String country = request.getParameter("country");
				String city = request.getParameter("city");
				String district = request.getParameter("district");
				String phone = request.getParameter("phone");
				String postalcode = request.getParameter("postalcode");
				String location = request.getParameter("location");
				
				
				Address a = new Address();
				
				a.setAddress_id(Integer.parseInt(address_id));
				a.setAddress(address);
				a.setAddress2(address2);
				a.setCity_id(Integer.parseInt(city));
				a.setCity(new City(Integer.parseInt(city), "", 0));
				a.setDistrict(district);
				a.setPhone(phone);
				a.setPostal_code(postalcode);
				a.setLocation(location);
				
				as.update(a);
				
			}
		}
		
		request.setAttribute("address", as.read());
		getServletContext().getRequestDispatcher("/view/address.jsp").forward(request, response);
	}

}
