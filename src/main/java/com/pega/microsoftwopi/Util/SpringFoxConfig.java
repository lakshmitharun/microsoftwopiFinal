package com.pega.microsoftwopi.Util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/files/**"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {

        return new ApiInfo("Spring Boot Webflux REST API", "Integrates PRPC Platform with Microsoft Office 365 ", "1.0", null, new Contact("Lakshmi Tharun, Ponnam", null, "lakshmitharun.ponnam@in.pega.com"), null, null, Collections.emptyList());

    }
}