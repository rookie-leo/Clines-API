package br.com.caelum.clines.api.airports;

public class AircraftLocationView {
	private String country;
	private String state;
	private String city;

	public AircraftLocationView(String country, String state, String city) {
		this.country = country;
		this.state = state;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

}
