package io.github.kevin_puertos.EasyPokeAPI.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class JsonConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return  new ObjectMapper();
    }



}
