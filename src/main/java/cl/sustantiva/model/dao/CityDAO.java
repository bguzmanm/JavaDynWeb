package cl.sustantiva.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.sustantiva.model.conn.Conexion;
import cl.sustantiva.model.entity.City;
import cl.sustantiva.model.entity.Country;

public class CityDAO implements ICityDAO {

	@Override
	public void create(City c) {
		
		try {
			Connection conn = Conexion.getConnection();
			String sql = "insert into city (city, country_id) values ('" + c.getCity() + "', " + c.getCountry_id()+ ")";
			
			Statement sta = conn.createStatement();
			
			sta.execute(sql);
			
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
			e.printStackTrace();
		}

	}

	@Override
	public List<City> read() {

		List<City> lista = new ArrayList<City>();
		
		try {
			Connection conn = Conexion.getConnection();
			String sql = "select  city_id, city, ci.country_id, c.country from city ci "
					+ "inner join country c on ci.country_id = c.country_id order by city";
			
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				lista.add(new City(rs.getInt("city_id"), rs.getString("city"), rs.getInt("country_id"), new Country(rs.getInt("country_id"), rs.getString("country"))));

			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
			e.printStackTrace();
		}
		
		
		return lista;
	}

	@Override
	public City read(int city_id) {

		City city = null;
		
		
		try {
			Connection conn = Conexion.getConnection();
			String sql = "select city_id, city, ci.country_id, c.country from city ci "
					+ "inner join country c on ci.country_id = c.country_id where city_id = " + city_id + " order by city";
			
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery(sql);
			
			if (rs.next()) {
				city = new City(rs.getInt("city_id"), rs.getString("city"), rs.getInt("country_id"), new Country(rs.getInt("country_id"), rs.getString("country")));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
			e.printStackTrace();
		}
		
		return city;
	}

	@Override
	public void update(City c) {

		try {
			Connection conn = Conexion.getConnection();
			String sql = "update city set city = '" + c.getCity() + "', country_id = " + c.getCountry_id() +
					" where city_id = " + c.getCity_id();
			
			Statement sta = conn.createStatement();
			
			sta.execute(sql);
			
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int city_id) {

		try {
			Connection conn = Conexion.getConnection();
			String sql = "delete from city where city_id = " + city_id;
			
			Statement sta = conn.createStatement();
			
			sta.execute(sql);
			
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
			e.printStackTrace();
		}

	}

	@Override
	public List<City> readByCountry(int country_id) {

		List<City> lista = new ArrayList<City>();
		
		try {
			Connection conn = Conexion.getConnection();
			String sql = "select  city_id, city, ci.country_id, c.country from city ci "
					+ "inner join country c on ci.country_id = c.country_id where ci.country_id = " + country_id + " order by city"; 
			
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				lista.add(new City(rs.getInt("city_id"), rs.getString("city"), rs.getInt("country_id")));

			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
			e.printStackTrace();
		}
		
		
		return lista;
	
	}

}
