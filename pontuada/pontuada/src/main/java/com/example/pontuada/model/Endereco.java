package com.example.pontuada.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

// Anotação que define esta classe como uma entidade JPA
@Entity
// Nome da tabela no banco de dados associada a esta entidade
@Table(name = "tabela_endereco")
public class Endereco
{
    // Define o campo id como a chave primária da tabela
    @Id
    // Configura a estratégia de geração automática do valor da chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Valida que o campo logradouro não pode ser nulo ou vazio
    @NotBlank(message = "Logradouro é obrigatório")
    private String logradouro;

    // Valida que o campo numero não pode ser nulo ou vazio
    @NotBlank(message = "Número é obrigatório")
    private String numero;

    // Valida que o campo complemento não pode ser nulo ou vazio
    @NotBlank(message = "Complemento é obrigatório")
    private String complemento;

    // Valida que o campo cidade não pode ser nulo ou vazio
    @NotBlank(message = "Cidade é obrigatório")
    private String cidade;

    // Construtor padrão sem argumentos para o JPA
    public Endereco()
    {
        
    }

    // Construtor com argumentos para inicializar os atributos
    public Endereco(Long id, @NotBlank(message = "Logradouro é obrigatório") String logradouro,
    @NotBlank(message = "Número é obrigatório") String numero,
    @NotBlank(message = "Complemento é obrigatório") String complemento,
    @NotBlank(message = "Cidade é obrigatório") String cidade)
    {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLogradouro()
    {
        return logradouro;
    }

    public void setLogradouro(String logradouro)
    {
        this.logradouro = logradouro;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public String getComplemento()
    {
        return complemento;
    }

    public void setComplemento(String complemento)
    {
        this.complemento = complemento;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade + "]";
    }
}