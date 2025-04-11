package com.example.pontuada.controller;

// Importa as anotações e classes necessárias do Spring Framework
import org.springframework.web.bind.annotation.*;

// Indica que esta classe é um controller REST
@RestController
// Define o mapeamento base para as requisições HTTP que esta classe irá tratar
@RequestMapping("/")
public class Welcome
{
    // Requisições HTTP GET para o método abaixo
    @GetMapping
    public String welcome()
    {
        // Mensagem de boas-vindas como resposta
        return "Bem-vindo ao sistema de funcionários!";
    }
}
