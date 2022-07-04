package br.com.caelum.clines.shared.exceptions;

import java.util.Collection;

public class ViolationException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	private final Collection<Exception> violations;

	public ViolationException(Collection<Exception> violations) {
		this.violations = violations;
	}

	public Collection<Exception> getViolations() {
		return violations;
	}
}
