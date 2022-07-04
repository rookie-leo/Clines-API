package br.com.caelum.clines.api.aircraftmodels;

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
@RequestMapping("aircraft-model")
public class AircraftModelController {
	
    private final AircraftModelService service;

    @Autowired
    public AircraftModelController(AircraftModelService service) {
		this.service = service;
	}

	@PostMapping
    ResponseEntity<?> createBy(@RequestBody @Valid AircraftModelForm form) {
        var id = service.createAircraftModelBy(form);

        var uri = URI.create("/aircraft-model/").resolve(String.valueOf(id));

        return created(uri).build();
    }
    
    @GetMapping
    List<AircraftModelView> list() {
        return service.listAllAircraftModels();
    }

    @GetMapping("{id}")
    AircraftModelView show(@PathVariable Long id) {
        return service.showAircraftModelBy(id);
    }
}
