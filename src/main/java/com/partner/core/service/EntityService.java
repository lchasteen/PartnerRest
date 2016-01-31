package com.partner.core.service;

import java.util.Collection;
import java.util.List;


public interface EntityService <T> {

	public List<T> getEntity(String lastName);
	public void setEntity(T person);
	public void deleteEntity(T person);
	public List<T> getAll();
}
