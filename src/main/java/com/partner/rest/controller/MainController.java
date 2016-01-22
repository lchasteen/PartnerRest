package com.partner.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/displayMessage/{msg}", method = RequestMethod.GET)
	public String displayMessage(@PathVariable String msg, ModelMap model) {
		model.addAttribute("msg", msg);
		return "helloWorld";
	}
}
