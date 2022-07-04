package br.com.caelum.clines.api.aircraft;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.caelum.clines.shared.exceptions.AircraftModelNotFoundException;
import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;

@Service
public class AircraftService {

    private final AircraftRepository repository;
    private final ExistingAircraftModelService modelService;
    private final AircraftViewMapper viewMapper;
    private final AircraftFormMapper formMapper;

    public AircraftService(AircraftRepository repository, ExistingAircraftModelService modelService,
			AircraftViewMapper viewMapper, AircraftFormMapper formMapper) {
		this.repository = repository;
		this.modelService = modelService;
		this.viewMapper = viewMapper;
		this.formMapper = formMapper;
	}

	public AircraftView showAircraftBy(String code) {

        var aircraft = repository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Cannot find aircraft"));

        return viewMapper.map(aircraft);
    }

    public List<AircraftView> listAllAircraft() {
        return repository.findAll().stream().map(viewMapper::map).collect(toList());
    }

    public String createAircraftBy(AircraftForm form) {
        repository.findByCode(form.getCode()).ifPresent(aircraft -> {
                throw new ResourceAlreadyExistsException("Aircraft already exists");
        });

        var model = modelService.findById(form.getModelId()).orElseThrow(() -> new AircraftModelNotFoundException("Cannot find aircraft model"));
        form.setModel(model);

        var aircraft = formMapper.map(form);

        repository.save(aircraft);

        return aircraft.getCode();
    }
}
