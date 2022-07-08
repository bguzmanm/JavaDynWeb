package cl.sustantiva.model.dao;

import java.util.List;

import cl.sustantiva.model.entity.Address;

public interface IAddressDAO {
	
	public void create(Address a);
	public List<Address> read();
	public Address read(int address_id);
	
	public List<Address> readByCity(int city_id);
	public List<Address> readByCountry(int country_id);
	
	public void update(Address a);
	public void delete(int address_id);
	

}
