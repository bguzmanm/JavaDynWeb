package cl.sustantiva.model.dao;

import java.util.List;

import cl.sustantiva.model.entity.Country;

/**
 *  Implementa CRUD
 *  C -> CREATE | Crear
 *  R -> READ 	| Leer
 *  U -> UPDATE | Actualizar
 *  D -> DELETE | Borrar
 */
public interface ICountryDAO {
	
	public void create(Country c);
	public List<Country> read();
	public Country read(int country_id);
	public void update(Country c);
	public void delete(int country_id);
	
	
}
