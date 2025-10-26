package com.example.swagger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {

	@Autowired
    private Environment environment;

    @Bean
    public OpenAPI defineOpenAPI () {
        Server server = new Server();
        String serverUrl = environment.getProperty("api.server.url");
        server.setUrl(serverUrl);
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Разработчик Разработчикович");
        myContact.setEmail("develop@cd.com");

        Info info = new Info()
                .title("API для работы с базой данных")
                .version("1.0")
                .description("Это API осуществуляет работу с базой данных")
                .contact(myContact);
        return new OpenAPI().info(info).servers(List.of(server));
    }
}
