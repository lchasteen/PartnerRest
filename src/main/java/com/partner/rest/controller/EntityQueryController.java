// FINAL
package com.partner.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.partner.core.model.Entity;
import com.partner.core.model.Persons;
import com.partner.core.service.EntityService;




@Controller
@RequestMapping("/users")
public class EntityQueryController {
    
    private EntityService<Entity> entityService;

    /**
     * Constructor auto wired to receive EntityService 
     * @param {@link EntityService} entityService
     */
    @Autowired
    public EntityQueryController(EntityService<Entity> entityService) {
        this.entityService = entityService;
    }
    
    

    /**
     * Stub method for get requests.
     */
    @RequestMapping(method = RequestMethod.GET)
    public void setupForm() {
		// Method is void, therefore a default view by the URL is assumed (reservationQuery)
	        // (i.e.@RequestMapping(/reservationQuery)) 
		// Based on resolver configuration the reservationQuery view
		// will be mapped to a JSP in /WEB-INF/jsp/reservationQuery.jsp 
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)      
    public @ResponseBody Persons getPersons() {
		
		Persons persons = new Persons();
		// Make a query if parameter is not null
	    persons.setPersons(entityService.getAll());	        
		 
	    return persons;
    }
    

    /**
     * @param {@link String} lastName    
     * @return (@link List} of {@link Entity}.
     */
    @RequestMapping(value = "/person/{lastName}", method = RequestMethod.GET)      
    public @ResponseBody Persons sumbitForm(@PathVariable("lastName") String lastName) {
		// Create reservation list
		
		Persons persons = new Persons();
		// Make a query if parameter is not null
	        if (lastName != null) {
	            persons.setPersons(entityService.getEntity(lastName));
	        }
		 
	    return persons;
    }
}