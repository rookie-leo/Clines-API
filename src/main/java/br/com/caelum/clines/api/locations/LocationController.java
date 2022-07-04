package br.com.caelum.clines.api.locations;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("location")
public class LocationController {

	private final LocationService service;

	@Autowired
	public LocationController(LocationService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> createBy(@RequestBody @Valid LocationForm form) {
		Long code = service.createLocationBy(form);

		URI uri = URI.create("/location/").resolve(code.toString());

		return created(uri).build();
	}

	@GetMapping
	public List<LocationView> list() {
		return service.listAllLocations();
	}

	@GetMapping("{id}")
	public LocationView show(@PathVariable("id") long id) {
		return service.showLocationBy(id);
	}
}
