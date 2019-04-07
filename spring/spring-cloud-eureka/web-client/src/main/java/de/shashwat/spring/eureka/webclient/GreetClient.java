package de.shashwat.spring.eureka.webclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-eureka-restclient")
public interface GreetClient {
	@RequestMapping("/greet")
    String greet();
}
