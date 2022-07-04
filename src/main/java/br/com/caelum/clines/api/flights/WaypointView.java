package br.com.caelum.clines.api.flights;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WaypointView {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime time;
	private String code;
	private String gate;

	public WaypointView(LocalDateTime time, String code, String gate) {
		this.time = time;
		this.code = code;
		this.gate = gate;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public String getCode() {
		return code;
	}

	public String getGate() {
		return gate;
	}

}
