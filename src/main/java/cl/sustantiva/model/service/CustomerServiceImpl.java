package cl.sustantiva.model.service;

import java.util.List;

import cl.sustantiva.model.dao.CustomerDAO;
import cl.sustantiva.model.dao.ICustomerDAO;
import cl.sustantiva.model.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	
	ICustomerDAO dao = new CustomerDAO();
	
	@Override
	public List<Customer> leer() {
		return dao.read();
	}

	@Override
	public Customer leer(int customer_id) {
		return dao.read(customer_id);
	}

	@Override
	public void actualizar(Customer c) {
		dao.update(c);
	}

	@Override
	public void crear(Customer c) {
		dao.create(c);
	}

	@Override
	public void borrar(int customer_id) {
		dao.delete(customer_id);
	}

}
