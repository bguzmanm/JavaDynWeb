package cl.sustantiva.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.sustantiva.model.conn.Conexion;
import cl.sustantiva.model.entity.City;

public class CityDAO implements ICityDAO {

	@Override
	public void create(City c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<City> read() {

		List<City> lista = new ArrayList<City>();
		
		try {
			Connection conn = Conexion.getConnection();
			String sql = "select city_id, city, country_id from city";
			
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				lista.add(new City(rs.getInt("city_id"), rs.getString("city"), rs.getInt("country_id")));

			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
		}
		
		
		return lista;
	}

	@Override
	public City read(int city_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int city_id) {
		// TODO Auto-generated method stub

	}

}
