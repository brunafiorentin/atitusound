package br.edu.atitus.pooavancado.atitusound.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {
    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API AtituSound")
                        .description("Documentação do backend AtituSound")
                        .version("Version 1.0.0")
                        .contact(new Contact()
                                .name("Dev Bruna Doi")
                                .email("1124117@atitus.edu.br")));
    }
}
