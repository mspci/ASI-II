package tn.esprit.tic.ds.springproj.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI openApiInformation() {
        Contact contact = new Contact().email("johnDoe@gmail.com").name("John Doe");
        Info info = new Info().contact(contact).description("Spring Boot Menu Project")
                .summary("Application with web services for ASI II Course")
                .title("Case Study: Menu")
                .version("1.0.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));
        return new OpenAPI().info(info);
    }

    @Bean
    public GroupedOpenApi menuPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Menu API")
                .pathsToMatch("/menu/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi otherApi() {
        return GroupedOpenApi.builder()
                .group("All except menu")
                .pathsToMatch("/**")
                .pathsToExclude("/menu/**") // Exclude menu paths
                .build();
    }

    @Bean
    public GroupedOpenApi allApis() {
        return GroupedOpenApi.builder()
                .group("All")
                .pathsToMatch("/**")
                .build();
    }
}
