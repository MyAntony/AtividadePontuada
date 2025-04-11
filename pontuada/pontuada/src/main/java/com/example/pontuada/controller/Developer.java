package com.example.pontuada.controller;

// Importa as anotações necessárias do Spring Framework
import org.springframework.web.bind.annotation.*;

// Indica que esta classe é um controlador REST
@RestController
// Define o mapeamento base para as requisições HTTP do controller
@RequestMapping("/dev")
public class Developer
{
    // Mapeia requisições HTTP GET para o método abaixo
    @GetMapping
    public String developer()
    {
        // Retorna uma string com o nome do desenvolvedor
        return "Desenvolvedor: Antony Rafael dos Santos Rufino";
    }
}
