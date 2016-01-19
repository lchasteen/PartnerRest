package com.partner.core.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeteringUnits {

	@JsonProperty("metering_units")
	private List<Meter> meteringUnits;

	public List<Meter> getMeteringUnits() {
		return meteringUnits;
	}

	public void setMeteringUnits(List<Meter> meteringUnits) {
		this.meteringUnits = meteringUnits;
	}
	
	
}
