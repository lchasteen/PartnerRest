package com.partner.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinate {	
	private String latitude;
	private String longitude;
	
	/**
	 * Creates new Coordinate.
	 * @param lat - {@link String} latitude
	 * @param lon - {@link String} longitude
	 */
	public Coordinate(String lat, String lon){
		
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
	
	

}
