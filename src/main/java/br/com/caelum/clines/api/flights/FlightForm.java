package br.com.caelum.clines.api.flights;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.caelum.clines.shared.domain.Aircraft;

public class FlightForm {
	@JsonIgnore
	private Aircraft aircraft;

	@Positive
	@NotNull
	private BigDecimal price;

	@NotBlank
	private String aircraftId;

	@NotNull
	@Valid
	private WaypointForm arrival;

	@NotNull
	@Valid
	private WaypointForm departure;

	public Aircraft getAircraft() {
		return aircraft;
	}
	
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(String aircraftId) {
		this.aircraftId = aircraftId;
	}

	public WaypointForm getArrival() {
		return arrival;
	}

	public WaypointForm getDeparture() {
		return departure;
	}

}
