package com.example.pontuada.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.example.pontuada.model.Funcionario;
import com.example.pontuada.service.FuncionarioService;
import jakarta.validation.Valid;
import java.util.List;

@RestController // Indica que esta classe é um controller REST
@RequestMapping("/funcionarios") // Define o endpoint base para os métodos deste controller
public class FuncionarioController
{
    private FuncionarioService funcionarioService;

    // Construtor para injetar a dependência do serviço de funcionário
    public FuncionarioController(FuncionarioService funcionarioService)
    {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping // Mapeia requisições GET para listar todos os funcionários
    public List<String> listarTodos()
    {
        return funcionarioService.listarTodos().stream().map(Funcionario::getNome).toList();
    }

    @PostMapping // Mapeia requisições POST para salvar um novo funcionário
    public ResponseEntity<String> salvar(@Valid @RequestBody Funcionario funcionario)
    {
        funcionarioService.salvar(funcionario); // Salva o funcionário recebido no corpo da requisição
        String mensagem = "Funcionário " + funcionario.getNome() + " cadastrado com sucesso!";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem); // Retorna uma mensagem de sucesso com status 201
    }

    @PutMapping // Mapeia requisições PUT para atualizar um funcionário existente
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario)
    {
        funcionarioService.atualizar(funcionario); // Atualiza o funcionário recebido no corpo da requisição
        return ResponseEntity.ok().body("Funcionário atualizado com sucesso!"); // Retorna uma mensagem de sucesso com status 200
    }

    @DeleteMapping("/{email}") // Requisições DELETE para excluir um funcionário pelo email
    public ResponseEntity<String> excluir(@PathVariable String email)
    {
        funcionarioService.excluir(email); // Exclui o funcionário com o email especificado
        return ResponseEntity.ok().body("Funcionário excluído com sucesso!"); // Retorna uma mensagem de sucesso com status 200
    }
}
