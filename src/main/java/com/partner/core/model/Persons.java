package com.partner.core.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persons {
	
	@JsonProperty("persons")
	private List<Entity> persons;

	/**
	 * 
	 */
	public List<Entity> getPersons() {
		return persons;
	}

	/**
	 * 
	 * @param persons
	 */
	public void setPersons(List<Entity> persons) {
		this.persons = persons;
	}
	
	
	

}
