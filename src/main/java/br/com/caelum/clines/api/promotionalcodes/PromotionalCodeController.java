package br.com.caelum.clines.api.promotionalcodes;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("promotional-code")
public class PromotionalCodeController {
	private final PromotionalCodeService service;

	@Autowired
	public PromotionalCodeController(PromotionalCodeService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> createBy(@RequestBody @Valid PromotionalCodeForm form) {
		String code = service.createPromotionalCodeBy(form);

		URI uri = URI.create("/promotional-code/").resolve(code);

		return created(uri).build();
	}
}
