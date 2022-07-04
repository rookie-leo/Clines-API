package br.com.caelum.clines.api.airports;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.caelum.clines.shared.domain.Location;


public class AirportForm {
    @JsonIgnore
    private Location location;

    @NotBlank
    private String code;

    @NotNull
    @Positive
    private Long locationId;

    public AirportForm(String code, Long locationId) {
        this.code = code;
        this.locationId = locationId;
    }

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
    
}
