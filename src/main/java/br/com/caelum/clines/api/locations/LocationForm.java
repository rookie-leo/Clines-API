package br.com.caelum.clines.api.locations;

import javax.validation.constraints.NotBlank;

public class LocationForm {
	@NotBlank
	private String country;

	@NotBlank
	private String state;

	@NotBlank
	private String city;

	public LocationForm(@NotBlank String country, @NotBlank String state, @NotBlank String city) {
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
