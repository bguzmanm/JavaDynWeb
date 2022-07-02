package cl.sustantiva.model.service;

import java.util.List;

import cl.sustantiva.model.dao.CityDAO;
import cl.sustantiva.model.dao.ICityDAO;
import cl.sustantiva.model.entity.City;

public class CityService {
	
	private ICityDAO cityDAO = new CityDAO();
	
	
	public List<City> read(){
		
		return cityDAO.read();
		
	}

}
