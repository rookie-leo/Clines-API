package br.com.caelum.clines.api.aircraft;

import static br.com.caelum.clines.shared.util.StringNormalizer.normalize;
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
@RequestMapping("aircraft")
public class AircraftController {

    private final AircraftService service;
    
    @Autowired
    public AircraftController(AircraftService service) {
		this.service = service;
	}

	@GetMapping("{code}")
    AircraftView show(@PathVariable String code) {
        return service.showAircraftBy(normalize(code));
    }

    @GetMapping
    List<AircraftView> list() {
        return service.listAllAircraft();
    }

    @PostMapping
    ResponseEntity<?> createBy(@RequestBody @Valid AircraftForm form) {
        var code = service.createAircraftBy(form);

        var uri = URI.create("/aircraft/").resolve(code);

        return created(uri).build();
    }
}
