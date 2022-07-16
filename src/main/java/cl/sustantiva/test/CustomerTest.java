package cl.sustantiva.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import cl.sustantiva.model.conn.Conexion;
import cl.sustantiva.model.entity.Customer;
import cl.sustantiva.model.service.CustomerService;
import cl.sustantiva.model.service.CustomerServiceImpl;

class CustomerTest {

	
	
	@Test
	void testConection() {
		Connection cnn = Conexion.getConnection();
		assertTrue(cnn!=null);
	}
	
	@Test
	void testCustomerRead() {
		CustomerService servicio = new CustomerServiceImpl();
		Customer c = servicio.leer(1);
		
		assertFalse(c.getCustomer_id() == 2);
		
	}
	
	
	
	

}
