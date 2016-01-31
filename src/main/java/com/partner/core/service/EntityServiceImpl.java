package com.partner.core.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.partner.core.model.Entity;


/**
 * 
 * @author Lane Chasteen
 *
 */
public class EntityServiceImpl implements EntityService <Entity> {
	// properties //
	private Map<String,Entity> entity;
	// constructors //
	public EntityServiceImpl(){
		entity = new HashMap<String,Entity>();
		String [] firstName = {"George","Sally","Walter","Bill","Dave","Andy","Bert","Jack","Wally","Doug"};
		String [] lastName = {"Douglas","Smith","Jenkins","Edwards","Luke","Jennings","Smithwick","Harper","Lankins","Lica"};
		for(String fName : firstName){
			for(String lName : lastName){
				Entity e = new Entity();
				UUID id = UUID.randomUUID();
				e.setId(id.toString());
				e.setFirstName(fName);
				e.setLastName(lName);
				setEntity(e);
			}
		}
	}

	@Override
	public List<Entity> getEntity(String lastName) {
		
		List<Entity> retList = new ArrayList<>();
		for (Entry <String,Entity> entry : entity.entrySet()) {
			if (entry.getValue().getLastName().equalsIgnoreCase(lastName)) {
				retList.add(entry.getValue());
			}
		}		
		return retList;
	}

	@Override
	public void setEntity(Entity entity) {
		if (!this.entity.containsKey(entity.getId())) {			
			this.entity.put(entity.getId(), entity);
		}
	}

	@Override
	public void deleteEntity(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Entity> getAll() {		
		return new ArrayList<Entity>(this.entity.values());
	}

}
