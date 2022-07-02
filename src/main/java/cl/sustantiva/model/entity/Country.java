package cl.sustantiva.model.entity;

public class Country {

	private int country_id;
	private String country;
	
	
	public Country() {
		super();
	}


	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
	}


	public int getCountry_id() {
		return country_id;
	}


	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + "]";
	}
	
	
	
	
}
