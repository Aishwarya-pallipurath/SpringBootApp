package com.cg.ebs;
  
  import org.springframework.context.annotation.Bean; 
  import org.springframework.context.annotation.Configuration;
  import springfox.documentation.builders.ApiInfoBuilder; 
import springfox.documentation.service.ApiInfo; 
import springfox.documentation.spi.DocumentationType; 
import springfox.documentation.spring.web.plugins.Docket; 
import  springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
  
  @Configuration 
  @EnableSwagger2
   public class ComplaintSwaggerConfiguration {
  
  @Bean 
  public Docket postApi() {
	  return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/.*")).build(); 
	  }
  
  private ApiInfo metadata() { 
	  return new ApiInfoBuilder().title("Electricity Billing System").
  description("API reference guide for developers").termsOfServiceUrl("").termsOfServiceUrl("https://www.java.com/").version("1.0").build();
 }
  
  
  }
 /*

@Configuration
@EnableSwagger2
public class ComplaintSwaggerConfiguration {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
                .PathSelectors.regex("/product.*")
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}
  */