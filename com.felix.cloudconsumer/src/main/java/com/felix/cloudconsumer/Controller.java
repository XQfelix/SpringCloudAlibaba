package com.felix.cloudconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private FeignInteface feignClient;
	
	
	@RequestMapping(value = "/consumer/{param}", method = RequestMethod.GET)
	public String echo(@PathVariable String param) {
		return feignClient.echo(param);
	}

}
