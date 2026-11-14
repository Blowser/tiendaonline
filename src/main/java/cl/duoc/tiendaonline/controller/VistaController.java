package cl.duoc.tiendaonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/perfil")
    public String perfil() {

        return "perfil";
    }
}