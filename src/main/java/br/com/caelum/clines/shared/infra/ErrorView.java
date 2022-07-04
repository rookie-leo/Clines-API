package br.com.caelum.clines.shared.infra;

import java.util.ArrayList;
import java.util.List;

public class ErrorView {
	private List<ErrorMessage> errors = new ArrayList<>();

	public void addGenericError(String message) {
		errors.add(new ErrorMessage(message));
	}

	public void addFieldError(String field, String message) {
		errors.add(new FieldErrorMessage(field, message));
	}

	@Override
	public String toString() {
		return "ErrorView{" + "errors=" + errors + '}';
	}

	public List<ErrorMessage> getErrors() {
		return errors;
	}

	static class ErrorMessage {
		private String message;

		public ErrorMessage(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		@Override
		public String toString() {
			return "ErrorMessage{" + "message='" + message + '\'' + '}';
		}
	}

	static class FieldErrorMessage extends ErrorMessage {
		private String field;

		FieldErrorMessage(String field, String message) {
			super(message);
			this.field = field;
		}

		public String getField() {
			return field;
		}

		@Override
		public String toString() {
			return "FieldErrorMessage{" + "field='" + field + '\'' + ", message='" + getMessage() + '\'' + '}';
		}
	}
}
