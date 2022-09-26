package mz.co.exchangerate.exchangeapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Exchance Rate API")
                        .description("Your Daily Exchange Rate API for currency conversion").version("1.0.0")
                        .contact(new Contact().name("Émerson Yuri Cuambe").url("https://github.com/FlossyYuri").email("emerson.yur@gmail.com")));
    }

    private Info apiInfo(){
        return  new Info().title("Exchance Rate API")
                .description("Your Daily Exchange Rate API for currency conversion")
                .version("1.0")
                .contact(contact())
                ;
    }

    private Contact contact(){
        return new Contact();
    }
}
