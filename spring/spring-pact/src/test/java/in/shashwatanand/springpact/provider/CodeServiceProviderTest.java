package in.shashwatanand.springpact.provider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.IgnoreNoPactsToVerify;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Provider("code-provider")
//@PactBroker(host = "localhost", port = "9292")
@PactFolder("build/pacts")
@IgnoreNoPactsToVerify
@Disabled
public class CodeServiceProviderTest {
	//@LocalServerPort
	//private int port;

	@BeforeEach
	void before(PactVerificationContext context) {
		//System.out.println("Port : " + port);
		context.setTarget(new HttpTestTarget("localhost", 8080));
	}

	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	void pactVerificationTestTemplate(PactVerificationContext context) {
		context.verifyInteraction();
	}
	
	@State("hello world")
	public void testHelloWorld() {}
	
	@State("Gen Java code")
	public void testGenJavaCode() {}
}
