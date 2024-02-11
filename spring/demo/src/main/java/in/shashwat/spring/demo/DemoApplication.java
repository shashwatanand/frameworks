package in.shashwat.spring.demo;

import in.shashwat.spring.demo.model.BlogPost;
import in.shashwat.spring.demo.repository.BlogPostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (BlogPostRepository repository) {
		return args -> repository.save(new BlogPost("Shashwat Blog", "Shashwat Blog Text"));
	}
}
