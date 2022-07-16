package cl.sustantiva.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.sustantiva.model.conn.Conexion;
import cl.sustantiva.model.entity.Customer;

public class CustomerDAO implements ICustomerDAO {

	@Override
	public void create(Customer c) {
		try {

			String sql = "insert into customer (first_name, last_name, email, active, store_id, address_id, create_date) "
					+ "values ('" + c.getFirst_name() + "', '" + c.getLast_name() + "', '" + c.getEmail() + "' " 
					+ ",  " + c.getActive() + ", 1, 1, now())";
			

			Connection cnn = Conexion.getConnection();
			Statement stt = cnn.createStatement();

			stt.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al crear Customer");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Customer read(int customer_id) {

		Customer customer = null;

		try {

			String sql = "select customer_id, first_name, last_name, email, active "
					+ " from customer where customer_id = " + customer_id;

			Connection cnn = Conexion.getConnection();
			Statement stt = cnn.createStatement();
			ResultSet rs = stt.executeQuery(sql);

			if (rs.next()) {
				customer = new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getInt("active"));

			}

		} catch (SQLException e) {
			System.out.println("Error al leer Customer");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customer;

	}

	@Override
	public List<Customer> read() {

		List<Customer> lista = new ArrayList<Customer>();

		try {

			String sql = "select customer_id, first_name, last_name, email, active from customer";

			Connection cnn = Conexion.getConnection();
			Statement stt = cnn.createStatement();
			ResultSet rs = stt.executeQuery(sql);

			while (rs.next()) {
				lista.add(new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getInt("active")));

			}

		} catch (SQLException e) {
			System.out.println("Error al leer Customers");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public void update(Customer c) {
		try {

			String sql = "update customer set first_name = '" + c.getFirst_name() + "', " + " last_name = '"
					+ c.getLast_name() + "', email = '" + c.getEmail() + "' " + ",  active = " + c.getActive()
					+ " where customer_id = " + c.getCustomer_id();

			Connection cnn = Conexion.getConnection();
			Statement stt = cnn.createStatement();

			stt.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al actualizar Customer");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int customer_id) {

		try {

			String sql = "delete from customer where customer_id = " + customer_id;
			
			Connection cnn = Conexion.getConnection();
			Statement stt = cnn.createStatement();

			stt.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al eliminar Customer");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
