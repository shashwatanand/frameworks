package in.shashwatanand.springpact;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import in.shashwatanand.springpact.model.JavaCode;

@Component
public class CodeControllerClient {
	private final RestTemplate restTemplate;

    public CodeControllerClient(@Value("${user-service.base-url}") String baseUrl) {
        this.restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public JavaCode getJavaCode(String className) {
        final JavaCode javaCode = restTemplate.getForObject("/getJavaCode" + className, JavaCode.class);
        Assert.hasText(javaCode.getClassName(), "Name is blank.");
        return javaCode;
    }
    
    public JavaCode genJavaCode(String url) {
    	RestTemplate endPoint = new RestTemplateBuilder().rootUri(url).build();
    	final JavaCode javaCode = endPoint.postForObject("/genJavaCode", null, JavaCode.class);
        //Assert.hasText(javaCode.getClassName(), "Generated class");
        return javaCode;
    }
    
    public String getHello(String url) {
    	RestTemplate endPoint = new RestTemplateBuilder().rootUri(url).build();
        return endPoint.getForObject("/hello", String.class);
    }
}
