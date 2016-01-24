package com.partner.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meter {
	
		private String id;
		@JsonProperty("coordinate")
		private Coordinate  coord;
		private String  street;
		private String  zipcode;

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Coordinate getCoord() {
			return coord;
		}
		public void setCoord(Coordinate coord) {
			this.coord = coord;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}		
}
