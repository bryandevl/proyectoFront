package com.Front.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-service", url = "https://backendciber.azurewebsites.net/")
public interface AuthClient {
	
	  // Método para consumir el servicio de autenticación
    @PostMapping("/autenticar")
    boolean autenticar(@RequestParam("username") String username, @RequestParam("password") String password);
}
