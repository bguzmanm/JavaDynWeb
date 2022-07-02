package cl.sustantiva.model.service;

import java.util.List;

import cl.sustantiva.model.dao.CountryDAO;
import cl.sustantiva.model.dao.ICountryDAO;
import cl.sustantiva.model.entity.Country;

public class CountryService {

	
	private ICountryDAO countryDAO = new CountryDAO();
	
	
	public List<Country> read(){
		
		return countryDAO.read();
		
		
	}
}
