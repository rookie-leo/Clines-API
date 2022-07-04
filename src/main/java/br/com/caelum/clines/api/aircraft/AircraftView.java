package br.com.caelum.clines.api.aircraft;

import br.com.caelum.clines.shared.domain.AircraftModel;

public class AircraftView {
    private String code;
    private AircraftModel model;
    
	public AircraftView(String code, AircraftModel model) {
		super();
		this.code = code;
		this.model = model;
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
