package br.com.caelum.clines.api.aircraftmodels;

import javax.validation.constraints.NotBlank;

public class AircraftModelForm {
	@NotBlank
	private String description;

	AircraftModelForm(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
