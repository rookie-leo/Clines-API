package br.com.caelum.clines.api.locations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.clines.shared.domain.Country;
import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;

@Service
public class LocationService {

	private final LocationRepository repository;
	private final LocationViewMapper viewMapper;
	private final LocationFormMapper formMapper;

	@Autowired
	public LocationService(LocationRepository repository, LocationViewMapper viewMapper,
			LocationFormMapper formMapper) {
		this.repository = repository;
		this.viewMapper = viewMapper;
		this.formMapper = formMapper;
	}

	public Long createLocationBy(LocationForm form) {
		repository.findByCountryAndStateAndCity(Country.findByDescription(form.getCountry()), form.getState(),
				form.getCity()).ifPresent(existingLocation -> {
					throw new ResourceAlreadyExistsException("Location already exists");
				});

		var location = formMapper.map(form);

		repository.save(location);

		return location.getId();
	}

	public List<LocationView> listAllLocations() {
		return repository.findAll().stream().map(viewMapper::map).collect(Collectors.toList());
	}

	public LocationView showLocationBy(Long id) {
		return repository.findById(id).map(viewMapper::map)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find location"));
	}
}
