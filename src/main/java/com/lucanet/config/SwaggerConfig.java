package com.lucanet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("Daniel Wagner", "http://lucanet.com/", "danielw@lucanet.com");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
            .title("Mini-REST-ERP")
            .description("This is a an ERP sample project based on Spring Boot. It allows you to request accounts, sub ledger accounts, cost centers, accounting areas, opening balances and postings.")
            .version("V1.0.0")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .contact(DEFAULT_CONTACT)
            .build();

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}