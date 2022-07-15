package cl.sustantiva.model.service;

import java.util.List;

import cl.sustantiva.model.entity.Customer;

public interface CustomerService {

	public List<Customer> leer();
	public Customer leer(int customer_id);
	public void actualizar(Customer c);
	
}
