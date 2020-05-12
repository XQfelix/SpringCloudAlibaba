package com.felix.cloudprovider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@RequestMapping(value = "/echo/{param}", method = RequestMethod.GET)
	public String echo(@PathVariable String param) {
		return "Hello " + param;
	}

}
