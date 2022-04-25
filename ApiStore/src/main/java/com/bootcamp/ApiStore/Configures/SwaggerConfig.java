package com.bootcamp.ApiStore.Configures;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.function.Predicate;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket apiDocket() {
        Predicate<RequestHandler> mainPackage = RequestHandlerSelectors.basePackage("com.bootcamp.ApiStore");
        Predicate<String> pathsSelected = PathSelectors.any();
        Docket apiDocketConf = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(mainPackage)
                .paths(pathsSelected)
                .build()
                .apiInfo(getApiInfo());

        return apiDocketConf;
    }

    private ApiInfo getApiInfo() {
        String title = "Store Api";
        String description = "An api about store management";
        String version = "1.0";
        String termsOfServiceUrl = "http://localhost:8000/terms";
        Contact contact = new Contact("Ariel", "http://localhost:8000", "arielsantangelo610@gmail.com");
        String license = "gpl";
        String licenseUrl ="gpl.org";

        return new ApiInfo(
                title,
                description,
                version,
                termsOfServiceUrl,
                contact,
                license,
                licenseUrl,
                Collections.emptyList()
        );
    }
}
