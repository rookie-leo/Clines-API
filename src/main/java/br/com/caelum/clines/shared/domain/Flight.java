package br.com.caelum.clines.shared.domain;

import java.math.BigDecimal;
import java.time.Duration;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal price;

	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "departure_id")
	private Waypoint departure;

	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "arrival_id")
	private Waypoint arrival;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "aircraft_id")
	private Aircraft aircraft;

	public Flight(BigDecimal price, Waypoint departure, Waypoint arrival, Aircraft aircraft) {
		this.price = price;
		this.departure = departure;
		this.arrival = arrival;
		this.aircraft = aircraft;
	}

	public Flight(Long id, @NotNull BigDecimal price, @NotNull Waypoint departure, @NotNull Waypoint arrival,
			@NotNull Aircraft aircraft) {
		this.id = id;
		this.price = price;
		this.departure = departure;
		this.arrival = arrival;
		this.aircraft = aircraft;
	}

	public Duration getDuration() {
		return Duration.between(departure.getTime(), arrival.getTime());
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Waypoint getDeparture() {
		return departure;
	}

	public Waypoint getArrival() {
		return arrival;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

}
