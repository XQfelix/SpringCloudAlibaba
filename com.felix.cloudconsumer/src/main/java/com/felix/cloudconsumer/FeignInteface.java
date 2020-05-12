package com.felix.cloudconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-provider",fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface FeignInteface {
	
	@RequestMapping(value = "/echo/{param}", method = RequestMethod.GET)
	String echo(@PathVariable("param") String param);
}

class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}

class EchoServiceFallback implements FeignInteface {
    @Override
    public String echo(@PathVariable("param") String param) {
        return "echo fallback";
    }
}
