package br.com.caelum.clines.shared.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "airports")
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String code;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public Airport() {}

	public Airport(String code, Location location) {
		this.code = code;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public Location getLocation() {
		return location;
	}

}
