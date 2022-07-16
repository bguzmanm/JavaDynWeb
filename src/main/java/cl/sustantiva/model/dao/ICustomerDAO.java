package cl.sustantiva.model.dao;


import cl.sustantiva.model.entity.Customer;
import java.util.List;


/**
 * C - Create 	- Crear
 * R - Read 	- Leer
 * U - Update	- Actualizar
 * D - Delete	- Borrar
 */

public interface ICustomerDAO {

	public void create(Customer c);
	public Customer read(int customer_id);
	public List<Customer> read();
	public void update(Customer c);
	public void delete(int customer_id);
	
}
