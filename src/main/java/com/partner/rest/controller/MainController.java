package com.partner.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.partner.core.dao.AssetImpl;
import com.partner.core.model.Meter;

@Controller
@RequestMapping("/assets")
public class MainController {
	
	
	@RequestMapping(value = "/list/meters", method = RequestMethod.GET)		
	public @ResponseBody List<Meter> getMeters() {
		AssetImpl impl = new AssetImpl();
		return impl.getMeters();
	}
	
	@RequestMapping(value = "/meter", method = RequestMethod.POST)
	public @ResponseBody String insertMeter(@RequestBody Meter meter) {
		System.out.println(meter.getId());
		System.out.println(meter.getStreet());
		System.out.println(meter.getZipcode());
		return "success";
	}
}
