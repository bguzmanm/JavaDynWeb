package cl.sustantiva.model.service;

import java.util.List;

import cl.sustantiva.model.dao.CountryDAO;
import cl.sustantiva.model.dao.ICountryDAO;
import cl.sustantiva.model.entity.Country;

public class CountryService {

	
	private ICountryDAO countryDAO = new CountryDAO();
	
	public void create(Country c) {
		countryDAO.create(c);
	}
	
	
	public List<Country> read(){
		return countryDAO.read();
	}
	
	public Country read(int country_id) {
		return countryDAO.read(country_id);
	}
	
	public void update(Country country) {
		countryDAO.update(country);
	}
	
	public void delete(int country_id) {
		countryDAO.delete(country_id);
	}
	
}
