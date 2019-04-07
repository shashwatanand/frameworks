package de.shashwat.spring.eureka.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@RestController
public class RestClientApp implements GreetController {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String applicationName;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApp.class, args);
	}

	@Override
	public String greet() {
		String greetStr = String.format("Greetings from '%s'!", eurekaClient.getApplication(this.applicationName).getName());
		return greetStr;
	}
}
