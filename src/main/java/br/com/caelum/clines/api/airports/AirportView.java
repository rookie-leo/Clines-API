package br.com.caelum.clines.api.airports;

public class AirportView {
	private String code;
	private AircraftLocationView location;

	public AirportView(String code, AircraftLocationView location) {
		this.code = code;
		this.location = location;
	}

	public String getCode() {
		return code;
	}

	public AircraftLocationView getLocation() {
		return location;
	}

}
