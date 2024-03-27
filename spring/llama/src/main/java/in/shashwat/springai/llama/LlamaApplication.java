package in.shashwat.springai.llama;

import in.shashwat.springai.llama.model.BlogPost;
import in.shashwat.springai.llama.repository.BlogPostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LlamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LlamaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (BlogPostRepository repository) {
		return args -> repository.save(new BlogPost("Shashwat Blog", "Shashwat Blog Text"));
	}

}
