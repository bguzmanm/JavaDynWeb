package cl.sustantiva.model.service;

import java.util.List;

import cl.sustantiva.model.dao.CityDAO;
import cl.sustantiva.model.dao.ICityDAO;
import cl.sustantiva.model.entity.City;

public class CityService {
	
	private ICityDAO cityDAO = new CityDAO();
	
	
	public void create(City c) {
		cityDAO.create(c);
	}
	
	public List<City> read(){
		return cityDAO.read();
	}
	
	public List<City> readByCountry(int country_id){
		return cityDAO.readByCountry(country_id);
	}
	
	public City read(int city_id) {
		return cityDAO.read(city_id);
	}
	
	public void update(City c) {
		cityDAO.update(c);
	}
	
	public void delete(int city_id) {
		cityDAO.delete(city_id);
	}
	

}
