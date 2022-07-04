package br.com.caelum.clines.api.promotionalcodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;

@Service
public class PromotionalCodeService {
	private final PromotionalCodeRepository repository;
	private final PromotionalCodeFormMapper formMapper;

	@Autowired
	public PromotionalCodeService(PromotionalCodeRepository repository, PromotionalCodeFormMapper formMapper) {
		this.repository = repository;
		this.formMapper = formMapper;
	}

	public String createPromotionalCodeBy(PromotionalCodeForm form) {
		repository.findByCode(form.getCode()).ifPresent(entity -> {
			throw new ResourceAlreadyExistsException("Promotional code already exists");
		});

		var promotionalCode = formMapper.map(form);

		promotionalCode = repository.save(promotionalCode);

		return promotionalCode.getCode();
	}
}
