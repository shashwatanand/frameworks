package de.shashwat.spring.eureka.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableFeignClients
@Controller
public class WebClientApplication {
	
	@Autowired
	private GreetClient greetClient;
	
	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
	}
	
	@RequestMapping("/get-greeting")
    public String greeting(Model model) {
		model.addAttribute("greet", greetClient.greet());
		return "view.html";
	}
}
