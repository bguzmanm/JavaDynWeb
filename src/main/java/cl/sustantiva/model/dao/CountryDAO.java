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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Country c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int country_id) {
		// TODO Auto-generated method stub

	}

}
