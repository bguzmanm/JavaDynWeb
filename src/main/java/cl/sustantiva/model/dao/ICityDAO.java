package cl.sustantiva.model.dao;

import java.util.List;

import cl.sustantiva.model.entity.City;



public interface ICityDAO {

	public void create(City c);
	public List<City> read();
	public City read(int city_id);
	public void update(City c);
	public void delete(int city_id);
	
}
