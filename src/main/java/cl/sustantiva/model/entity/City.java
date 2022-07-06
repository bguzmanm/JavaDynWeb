package cl.sustantiva.model.entity;

public class City {

	private int city_id;
	private String city;
	private int country_id;
	private Country country;
	
	public City() {
		super();
	}

	public City(int city_id, String city, int country_id) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.country_id = country_id;
	}
	
	public City(int city_id, String city, int country_id, Country country) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.country_id = country_id;
		this.country = country;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", country_id=" + country_id + "]";
	}
	
	
	
	
}
