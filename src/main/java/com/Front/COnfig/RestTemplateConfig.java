package com.Front.COnfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	  // Crea una instancia de RestTemplate para ser utilizada en otros servicios
	//Esta clase configura un bean de RestTemplate, que se utiliza para realizar solicitudes HTTPenel proyecto
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}