package br.com.caelum.clines.api.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.caelum.clines.api.aircraft.AircraftViewMapper;
import br.com.caelum.clines.shared.domain.Flight;

@Component
public class FlightViewFactory {

	private final WaypointViewMapper waypointViewMapper;
	private final AircraftViewMapper aircraftViewMapper;

	@Autowired
	public FlightViewFactory(WaypointViewMapper waypointViewMapper, AircraftViewMapper aircraftViewMapper) {
		this.waypointViewMapper = waypointViewMapper;
		this.aircraftViewMapper = aircraftViewMapper;
	}

	FlightView factory(Flight flight) {
		var departure = flight.getDeparture();
		var arrival = flight.getArrival();
		var aircraft = flight.getAircraft();

		var departureView = waypointViewMapper.map(departure);
		var arrivalView = waypointViewMapper.map(arrival);
		var aircraftView = aircraftViewMapper.map(aircraft);

		return new FlightView(flight.getId(), flight.getPrice(), departureView, arrivalView, aircraftView);
	}
}
