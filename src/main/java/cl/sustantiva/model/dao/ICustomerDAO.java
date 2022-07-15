package cl.sustantiva.model.dao;


import cl.sustantiva.model.entity.Customer;
import java.util.List;


public interface ICustomerDAO {

	public void create(Customer c);
	public Customer read(int customer_id);
	public List<Customer> read();
	public void update(Customer c);
	public void delete(int customer_id);
	
}
