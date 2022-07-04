package br.com.caelum.clines.api.aircraftmodels;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;

@Service
public class AircraftModelService {
    private final AircraftModelRepository repository;
    private final AircraftModelFormMapper formMapper;
    private final AircraftModelViewMapper viewMapper;

    public AircraftModelService(AircraftModelRepository repository, AircraftModelFormMapper formMapper,
			AircraftModelViewMapper viewMapper) {
		this.repository = repository;
		this.formMapper = formMapper;
		this.viewMapper = viewMapper;
	}

	public Long createAircraftModelBy(AircraftModelForm form) {
        repository.findByDescription(form.getDescription()).ifPresent(
                (existingAircraftModel) -> {
                    throw new ResourceAlreadyExistsException("Aircraft Model already exists");
                });
        var aircraftModel = formMapper.map(form);

        repository.save(aircraftModel);

        return aircraftModel.getId();
    }
    
    public List<AircraftModelView> listAllAircraftModels() {
        return repository.findAll().stream().map(viewMapper::map).collect(toList());
    }

    public AircraftModelView showAircraftModelBy(Long aircraftModelId) {
        var aircraftModel = repository.findById(aircraftModelId).orElseThrow(() -> new ResourceNotFoundException("Cannot find aircraft model"));
        return viewMapper.map(aircraftModel);
    }
}
