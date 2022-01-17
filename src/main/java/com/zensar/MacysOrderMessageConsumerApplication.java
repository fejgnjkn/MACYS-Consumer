package com.zensar;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MacysOrderMessageConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacysOrderMessageConsumerApplication.class, args);
		
		System.out.println("Inside consumer");
	}
	
//	@Bean
//	public Docket getDocket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(getApiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.zensar"))
//				.paths(PathSelectors.any())
//				.build();
//	}
//	
//	private ApiInfo getApiInfo() {
//		return new ApiInfo(
//			      "MACY'S Message Producer REST Api documention",
//			      "MACY'S Message Producer REST api doc released by Zensar",
//			      "1.0",
//			      "http://zensar.com",
//			      new Contact("MACY'S Message Producer","http://xensar.com","contact@zensar.com"),
//			      "HTTP",
//			      "GPA",
//			      new ArrayList<VendorExtension>());
//	}

}
