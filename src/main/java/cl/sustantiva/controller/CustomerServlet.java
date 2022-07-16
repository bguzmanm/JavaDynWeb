package cl.sustantiva.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sustantiva.model.entity.Customer;
import cl.sustantiva.model.service.CustomerService;
import cl.sustantiva.model.service.CustomerServiceImpl;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerServlet() {
		super();
	}

	CustomerService service = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		if (op == null) {
			op = "list";
		}

		String jsp = "/view/customers.jsp";

		request.setAttribute("op", op);

		switch (op) {
		case "list": {

			request.setAttribute("customers", service.leer());

			break;
		}
		case "edit": {

			String id = request.getParameter("id");

			request.setAttribute("customer", service.leer(Integer.parseInt(id)));
			jsp = "/view/customer.jsp";

			break;
		}
		case "new": {
			jsp = "/view/customer.jsp";
			break;
		}		
		case "del": {
			//obtengo el ID de Customer que se quiere borrar.
			String id = request.getParameter("id");
			//borramos el cliente
			service.borrar(Integer.parseInt(id));
			
			//obtengo la lista de clietnes restantes, y se las paso al request.
			request.setAttribute("customers", service.leer());
			break;
		}
		
		default:
			break;
		}

		getServletContext().getRequestDispatcher(jsp).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		if (op == null) {
			op = "new";
		}

		String jsp = "/view/customers.jsp";

		request.setAttribute("op", op);

		switch (op) {
		case "new": {

			Customer c = new Customer();
			c.setCustomer_id(0);
			c.setFirst_name(request.getParameter("first_name"));
			c.setLast_name(request.getParameter("last_name"));
			c.setEmail(request.getParameter("email"));
			c.setActive(Integer.parseInt(request.getParameter("active")));
			
			service.crear(c);
			
			break;
		}
		case "edit": {

			String id = request.getParameter("customer_id");			
			Customer c = service.leer(Integer.parseInt(id));
			
			c.setFirst_name(request.getParameter("first_name"));
			c.setLast_name(request.getParameter("last_name"));
			c.setEmail(request.getParameter("email"));
			c.setActive(Integer.parseInt(request.getParameter("active")));
			
			service.actualizar(c);

			break;
		}
		default:
			break;
		}

		request.setAttribute("customers", service.leer());
		jsp = "/view/customers.jsp";
		
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
		
	}

}
