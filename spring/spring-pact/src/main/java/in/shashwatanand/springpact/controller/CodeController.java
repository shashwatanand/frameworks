package in.shashwatanand.springpact.controller;

import org.springframework.web.bind.annotation.RestController;

import in.shashwatanand.springpact.model.JavaCode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CodeController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from spring with pact project";
	}
	
	@GetMapping("/getJavaCode")
	public ResponseEntity<JavaCode> getJavaCode(@RequestParam String className) {
		JavaCode javaCode = new JavaCode(className);
		return new ResponseEntity<>(javaCode, HttpStatus.OK);
	}
	
	@PostMapping("/genJavaCode")
	public ResponseEntity<JavaCode> genJavaCode() {
		JavaCode javaCode = new JavaCode("Generated class");
		return new ResponseEntity<>(javaCode, HttpStatus.OK);
	}
}
