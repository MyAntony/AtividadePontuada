package com.example.pontuada.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pontuada.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{
    Optional<Funcionario> findByEmail(String Email);
}
