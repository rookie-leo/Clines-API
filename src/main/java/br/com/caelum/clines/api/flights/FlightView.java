package br.com.caelum.clines.api.flights;

import java.math.BigDecimal;

import br.com.caelum.clines.api.aircraft.AircraftView;

public class FlightView {
	private Long id;
	private BigDecimal price;
	private WaypointView departure;
	private WaypointView arrival;
	private AircraftView aircraft;

	public FlightView(Long id, BigDecimal price, WaypointView departure, WaypointView arrival, AircraftView aircraft) {
		this.id = id;
		this.price = price;
		this.departure = departure;
		this.arrival = arrival;
		this.aircraft = aircraft;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public WaypointView getDeparture() {
		return departure;
	}

	public WaypointView getArrival() {
		return arrival;
	}

	public AircraftView getAircraft() {
		return aircraft;
	}

}
