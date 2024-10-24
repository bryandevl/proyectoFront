package com.Front.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Service
public class IntegrantesService {

    private final RestTemplate restTemplate;
    
    // Inyección de RestTemplate

    @Autowired
    public IntegrantesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    
 // Método para obtener la lista de integrantes desde el backend
    public List<String> getIntegrantes() {
        String[] integrantes = restTemplate.getForObject("https://backendciber.azurewebsites.net/get-integrantes", String[].class);
        return Arrays.asList(integrantes);
    }
}