package cl.sustantiva.model.service;

import java.util.List;

import cl.sustantiva.model.dao.AddressDAO;
import cl.sustantiva.model.dao.IAddressDAO;
import cl.sustantiva.model.entity.Address;

public class AddressService {
	
	IAddressDAO aDAO = new AddressDAO();
	
	public List<Address> read(){
		return aDAO.read();
	}
	
	public Address read(int address_id) {
		return aDAO.read(address_id);
	}
	
	
	public void update(Address a) {
		aDAO.update(a);
	}
	

}
