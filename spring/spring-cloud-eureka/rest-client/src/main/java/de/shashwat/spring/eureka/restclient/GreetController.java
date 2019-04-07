package de.shashwat.spring.eureka.restclient;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetController {
	@RequestMapping("/greet")
	String greet();
}
