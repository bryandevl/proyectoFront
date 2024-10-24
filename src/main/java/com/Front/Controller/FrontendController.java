package com.Front.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.Front.Client.AuthClient;
import com.Front.Client.IntegrantesService;

@Controller
public class FrontendController {

    @Autowired
    private AuthClient authService; // Cliente Feign para la autenticación


    @Autowired
    private IntegrantesService integrantesService; // Servicio para obtener los integrantes


    // Muestra la página de login
    @GetMapping("/")
    public String index() {
        return "login"; // Devuelve la vista login.html
    }

    // Procesa el formulario de login
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Llama al servicio de autenticación
        boolean authenticated = authService.autenticar(username, password);
        if (authenticated) {
            // Si es autenticado, agrega la lista de integrantes al modelo y muestra la página de detalle
            model.addAttribute("integrantes", integrantesService.getIntegrantes());
            return "detalle"; // Redirige a detalle.html
        } else {
            // Si falla la autenticación, muestra el mensaje de error en la página de login
            model.addAttribute("error", "Problemas en la autenticación");
            return "login"; // Redirige nuevamente a login.html
        }
    }

    @GetMapping("/detalle")
    public String detalle(Model model) {
        model.addAttribute("integrantes", integrantesService.getIntegrantes());
        return "detalle";
    }


}