package br.com.caelum.clines.api.aircraft;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.caelum.clines.shared.domain.AircraftModel;

class AircraftForm {
    @JsonIgnore
    private AircraftModel model;

    @NotBlank
    private String code;

    @NotNull
    @Positive
    private Long modelId;

     AircraftForm(String code, Long modelId) {
        this.code = code;
        this.modelId = modelId;
    }

	public AircraftModel getModel() {
		return model;
	}

	public String getCode() {
		return code;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModel(AircraftModel model) {
		this.model = model;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

}
