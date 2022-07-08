package cl.sustantiva.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.sustantiva.model.conn.Conexion;
import cl.sustantiva.model.entity.Address;
import cl.sustantiva.model.entity.City;
import cl.sustantiva.model.entity.Country;

public class AddressDAO implements IAddressDAO {

	@Override
	public void create(Address a) {
		
	}

	@Override
	public List<Address> read() {
		
		List<Address> lista = new ArrayList<Address>();
		
		try {
			
			String sql = "select address_id, address, address2, district, a.city_id, c.city, "
					+ "       c.country_id, c2.country, postal_code, phone, ST_AsText(location) location "
					+ "from address a inner join city c on a.city_id = c.city_id "
					+ "inner join country c2 on c.country_id = c2.country_id";
			
			Connection cnn = Conexion.getConnection();
			Statement stt = cnn.createStatement();
			
			ResultSet rs = stt.executeQuery(sql);
			
			while (rs.next()) {
				lista.add(new Address(rs.getInt("address_id"),
						rs.getString("address"),
						rs.getString("address2"),
						rs.getString("district"),
						rs.getInt("city_id"),
						new City(rs.getInt("city_id"), 
								rs.getString("city"), 
								rs.getInt("country_id"), 
								new Country(rs.getInt("country_id"), 
										rs.getString("country"))),
						rs.getString("postal_code"),
						rs.getString("phone"),
						rs.getString("location")));

			}			
			
		} catch (SQLException e) {
			System.err.println("Error al consultar la BD.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Address read(int address_id) {

		Address address = null;
		
		try {
			
			String sql = "select address_id, address, address2, district, a.city_id, c.city, "
					+ "       c.country_id, c2.country, postal_code, phone, ST_AsText(location) location "
					+ "from address a inner join city c on a.city_id = c.city_id "
					+ "inner join country c2 on c.country_id = c2.country_id where address_id = " + address_id;
			
			Connection cnn = Conexion.getConnection();
			Statement stt = cnn.createStatement();
			
			ResultSet rs = stt.executeQuery(sql);
			
			if (rs.next()) {
				address = new Address(rs.getInt("address_id"),
						rs.getString("address"),
						rs.getString("address2"),
						rs.getString("district"),
						rs.getInt("city_id"),
						new City(rs.getInt("city_id"), 
								rs.getString("city"), 
								rs.getInt("country_id"), 
								new Country(rs.getInt("country_id"), 
										rs.getString("country"))),
						rs.getString("postal_code"),
						rs.getString("phone"),
						rs.getString("location"));

			}			
			
		} catch (SQLException e) {
			System.err.println("Error al consultar la BD.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public List<Address> readByCity(int city_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> readByCountry(int country_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Address a) {
		
		try {
			
			String sql = "update address set address = '" + a.getAddress() + "', address2 = '" + a.getAddress2() + "' , district = '" + a.getDistrict() 
				+ "', city_id = " +  a.getCity_id() + ", postal_code = '" + a.getPostal_code() + "', phone = '" + a.getPhone() //, ST_AsText(location) location"
				+ "' where address_id = " + a.getAddress_id();
			
			Connection cnn = Conexion.getConnection();
			
			Statement stm = cnn.createStatement();
			
			stm.execute(sql);
			
			
		} catch (SQLException e) {
			System.err.println("ERror al actualizar la BD.");
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int address_id) {
		// TODO Auto-generated method stub
		
	}

}
