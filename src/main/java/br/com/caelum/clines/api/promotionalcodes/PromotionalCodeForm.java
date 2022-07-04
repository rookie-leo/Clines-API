package br.com.caelum.clines.api.promotionalcodes;

import java.time.LocalDate;

public class PromotionalCodeForm {
	private String code;
	private LocalDate startDate;
	private LocalDate expirationDate;
	private String description;
	private Integer discount;

	public PromotionalCodeForm(String code, LocalDate startDate, LocalDate expirationDate, String description,
			Integer discount) {
		this.code = code;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.description = description;
		this.discount = discount;
	}

	public String getCode() {
		return code;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public String getDescription() {
		return description;
	}

	public Integer getDiscount() {
		return discount;
	}

}
