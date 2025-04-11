package com.example.pontuada.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.example.pontuada.model.Funcionario;
import com.example.pontuada.repository.FuncionarioRepository;

import jakarta.validation.Valid;

@Service // Indica que esta classe é um serviço do Spring
@Validated // Habilita a validação de objetos anotados com @Valid
public class FuncionarioService
{
    private FuncionarioRepository funcionarioRepository;

    // Construtor para injetar o repositório de funcionários
    public FuncionarioService(FuncionarioRepository funcionarioRepository)
    {
        this.funcionarioRepository = funcionarioRepository;
    }

    // Método para listar todos os funcionários
    public List<Funcionario> listarTodos()
    {
        return funcionarioRepository.findAll();
    }

    // Método para salvar um novo funcionário
    public Funcionario salvar(@Valid Funcionario funcionario)
    {
        // Verifica se já existe um funcionário com o mesmo e-mail
        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent())
        {
            throw new RuntimeException("E-mail já cadastrado!");
        }

        // Salva o funcionário
        return funcionarioRepository.save(funcionario);
    }

    // Método para atualizar os dados de um funcionário existente
    public Funcionario atualizar(@Valid Funcionario funcionario)
    {
        // Busca o funcionário pelo e-mail, lança exceção se não encontrado
        Funcionario funcionarioAtualizar = funcionarioRepository.findByEmail(funcionario.getEmail()).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        // Atualiza os dados do funcionário
        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioAtualizar.setSalario(funcionario.getSalario());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());

        // Salva as alterações
        return funcionarioRepository.save(funcionarioAtualizar);
    }

    // Método para excluir um funcionário pelo e-mail
    public void excluir(String email)
    {
        // Busca o funcionário pelo e-mail, lança exceção se não encontrado
        Funcionario funcionario = funcionarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Funcionario não encontrado!"));

        // Exclui o funcionário pelo ID
        funcionarioRepository.deleteById(funcionario.getId());
    }
}
