package in.shashwatanand.springpact.consumer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import in.shashwatanand.springpact.CodeControllerClient;
import in.shashwatanand.springpact.model.JavaCode;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, properties = "user-service.base-url:http://localhost:8080", classes = CodeControllerClient.class)
@ExtendWith(PactConsumerTestExt.class)
public class CodeServiceContractTest {

	@Autowired
	private CodeControllerClient codeControllerClient;

	@Pact(consumer = "code-consumer")
	public RequestResponsePact pactForHelloWorld(PactDslWithProvider builder) {
		Map<String, String> reqHeaders = new HashMap<>();
		reqHeaders.put("content-type", "text/plain");
		
		return builder
				.given("hello world")
				.uponReceiving("hello request")
					.path("/hello")
					.method("GET")
				.willRespondWith().status(200)
					//.body(new PactDslJsonBody().stringType("Hello from spring with pact project"))
					.body("Hello from spring with pact project")
					//.body(LambdaDsl.newJsonBody((o) -> o.stringType("Hello from spring with pact project")).build())
				.toPact();
	}
	
	@Pact(consumer = "code-consumer")
	public RequestResponsePact pactForGenJavaCode(PactDslWithProvider builder) {
		Map<String, String> reqHeaders = new HashMap<>();
		reqHeaders.put("content-type", "text/plain");
		
		return builder
				.given("Gen Java code")
				.uponReceiving("Gen Java code")
					.path("/genJavaCode")
					.method("POST")
				.willRespondWith().status(200)
					//.body("Generated class")
				.toPact();
	}

	@PactTestFor(pactMethod = "pactForHelloWorld", pactVersion = PactSpecVersion.V3)
	@Test
	public void userExists(MockServer mockServer) {
		String returnStr = codeControllerClient.getHello(mockServer.getUrl());
		assertThat(returnStr).isEqualTo("Hello from spring with pact project");
	}
	
	@PactTestFor(pactMethod = "pactForGenJavaCode", pactVersion = PactSpecVersion.V3)
	@Test
	public void genJavaCode(MockServer mockServer) {
		JavaCode javaCode = codeControllerClient.genJavaCode(mockServer.getUrl());
		//assertThat(returnStr).isEqualTo("Hello from spring with pact project");
	}
}
