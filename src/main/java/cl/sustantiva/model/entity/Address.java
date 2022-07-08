package cl.sustantiva.model.entity;

public class Address {
	
	private int address_id;
	private String address;
	private String address2;
	private String district;
	private int city_id;
	private City city;
	private String postal_code;
	private String phone;
	private String location;
	
	
	public Address() {
		super();
	}


	public Address(int address_id, String address, String address2, String district, int city_id, City city,
			String postal_code, String phone, String location) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city_id = city_id;
		this.city = city;
		this.postal_code = postal_code;
		this.phone = phone;
		this.location = location;
	}


	public int getAddress_id() {
		return address_id;
	}


	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public int getCity_id() {
		return city_id;
	}


	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public String getPostal_code() {
		return postal_code;
	}


	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
		

}
