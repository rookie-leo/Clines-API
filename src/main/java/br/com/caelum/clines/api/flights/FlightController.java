package br.com.caelum.clines.api.flights;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.clines.api.locations.LocationView;

@RestController
@RequestMapping("flights")
public class FlightController {

	private final FlightService services;

	public FlightController(FlightService services) {
		this.services = services;
	}

	@GetMapping("{id}")
	FlightView show(@PathVariable Long id) {
		return services.showFlightBy(id);
	}

	@GetMapping
	List<FlightView> list() {
		return services.listAllFlights();
	}

	@PostMapping
	ResponseEntity<?> register(@RequestBody @Valid FlightForm form) {
		var id = services.createNewFlightBy(form);
		var uri = URI.create("/flights/").resolve(id.toString());

		return created(uri).build();
	}

	@GetMapping("/search")
	ResponseEntity<?> search(
			@RequestParam(name = "date", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
			@RequestParam(name = "country", required = false) String country,
			@RequestParam(name = "state", required = false) String state,
			@RequestParam(name = "city", required = false) String city) {
		LocationView location = new LocationView(country, state, city);

		List<FlightView> fligthts = services.searchBy(parseToLocalDateTime(date), location);
		return ResponseEntity.ok(fligthts);
	}

	private LocalDateTime parseToLocalDateTime(LocalDate date) {
		return date != null ? date.atStartOfDay() : null;
	}

}
