package com.partner.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinate {	
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longitude")
	private String longitude;
	
	/**
	 * Creates new Coordinate.
	 * @param lat - {@link String} latitude
	 * @param lon - {@link String} longitude
	 */
	public Coordinate(String latitude, String longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * Creates new Coordinate.
	 */
	public Coordinate(){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLatitude() {
		return latitude;
	}
	
	/**
	 * 
	 * @param latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Returns the string value for the longitude of the {@link Coordinate}
	 * @return longitude of the {@link Coordinate}
	 */
	public String getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the longitude for the {@link Coordinate} Object. 
	 * @param longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	@Override
	public String toString() {
		return latitude + " " + longitude;
	}
	

}
