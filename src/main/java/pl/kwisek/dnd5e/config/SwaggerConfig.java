package pl.kwisek.dnd5e.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
            new Info()
                .title("DnD 5e API")
                .description("Dungeons & Dragons 5e API")
                .version("0.0.1")
            );
    }

}
