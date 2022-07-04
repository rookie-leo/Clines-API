package br.com.caelum.clines.shared.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "promotional_codes")
public class PromotionalCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private String description;

    @NotNull
    private Integer discount;

    public PromotionalCode(String code, LocalDate startDate, LocalDate expirationDate, String description, int discount) {
        this.code = code;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.description = description;
        this.discount = discount;
    }

	public Long getId() {
		return id;
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
