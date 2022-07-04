package br.com.caelum.clines.shared.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String code;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "model_id")
    private AircraftModel model;

    public Aircraft() {}
    
    public Aircraft(String code, AircraftModel model) {
        this.code = code;
        this.model = model;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AircraftModel getModel() {
		return model;
	}

	public void setModel(AircraftModel model) {
		this.model = model;
	}

}
