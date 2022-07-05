package cl.sustantiva.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.sustantiva.model.conn.Conexion;
import cl.sustantiva.model.entity.Country;

public class CountryDAO implements ICountryDAO {

	
	
	@Override
	public void create(Country c) {


		try {
			
			String sql = "insert into country (country) values ('" + c.getCountry() + "')";
			
			Connection conn = Conexion.getConnection();
			Statement sta = conn.createStatement();
			
			sta.execute(sql);
			
		} catch (SQLException e) {
			System.out.println("Error al crear Country");
			e.printStackTrace();
		}

	}

	@Override
	public List<Country> read() {

		List<Country> lista = new ArrayList<Country>();
		
		try {
			
			Connection conn = Conexion.getConnection();
			String sql = "select country_id, country from country";
			
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery(sql);
			
			while (rs.next()) {
				lista.add(new Country(rs.getInt("country_id"), rs.getString("country")));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
			e.printStackTrace();
		}
		
		
		return lista;
	}

	@Override
	public Country read(int country_id) {
		
		Country country = new Country();
		
		try {
			
			Connection conn = Conexion.getConnection();
			String sql = "select country_id, country from country where country_id = " + country_id;
			
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery(sql);
			
			if (rs.next()) {
				country.setCountry_id(rs.getInt("country_id"));
				country.setCountry(rs.getString("country"));
			}
						
		} catch (SQLException e) {
			System.out.println("Error al consultar la BD.");
			e.printStackTrace();
		}
		
		return country;
	}

	@Override
	public void update(Country c) {

		try {
			
			String sql = "update country set country = '" + c.getCountry() + "' where country_id = " + c.getCountry_id();
			
			Connection conn = Conexion.getConnection();
			Statement sta = conn.createStatement();
			
			sta.execute(sql);
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar Country");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int country_id) {

		try {
			
			String sql = "delete from country where country_id = " + country_id;
			
			
			Connection conn = Conexion.getConnection();
			Statement sta = conn.createStatement();
			
			sta.execute(sql);
			
		} catch (SQLException e) {
			System.out.println("Error al borrar Country");
			e.printStackTrace();
		}
	}

}
