package cl.sustantiva.model.service;

import java.util.List;

import cl.sustantiva.model.entity.Customer;

public interface CustomerService {

	public void crear(Customer c); 			// --> Create
	public List<Customer> leer(); 			// --> Read todo
	public Customer leer(int customer_id);	// --> Read solo uno
	public void actualizar(Customer c);		// --> Update
	public void borrar(int customer_id);	// --> Delete
	
}
