package com.example.pontuada.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

// Anotação para indicar que esta classe é uma entidade JPA
@Entity
public class Funcionario
{

    // Identificador único da entidade, gerado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Validação para garantir que o nome não seja nulo ou vazio
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    // Validação para garantir que o CPF não seja nulo, vazio e tenha exatamente 11 dígitos
    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
    private String cpf;

    // Validação para garantir que a data de nascimento não seja nula, vazia e tenha o formato correto
    @NotBlank(message = "Data de Nascimento é obrigatório")
    @Size(min = 10, max = 10, message = "A data de nascimento deve ter o formato dd/MM/yyyy")
    private String dataNascimento;

    // Enum para representar o sexo do funcionário
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    // Enum para representar o setor do funcionário
    @Enumerated(EnumType.STRING)
    private Setor setor;

    // Enum para representar o estado civil do funcionário
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    // Validação para garantir que o salário não seja nulo e tenha um valor mínimo de R$ 1.518,00
    @NotNull(message = "Salário é obrigatória")
    @DecimalMin(value = "1518.00", inclusive = true, message = "O salário deve ser no mínimo R$ 1.518,00")
    private Double salario;

    // Validação para garantir que o email não seja nulo, vazio e seja um email válido
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Informe um e-mail válido")
    private String email;

    // Relacionamento de um para um com a entidade Endereco, com cascata para operações persistentes
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    // Construtor padrão
    public Funcionario()
    {
    }

    // Construtor com todos os atributos
    public Funcionario(Long id, @NotBlank(message = "Nome é obrigatório") String nome,
    @NotBlank(message = "CPF é obrigatório") @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos") String cpf,
    @NotBlank(message = "Data de Nascimento é obrigatório") @Size(min = 10, max = 10, message = "A data de nascimento deve ter o formato dd/MM/yyyy") String dataNascimento,
    Sexo sexo, Setor setor, EstadoCivil estadoCivil,
    @NotNull(message = "Salário é obrigatória") @DecimalMin(value = "1518.00", inclusive = true, message = "O salário deve ser no mínimo R$ 1.518,00") Double salario,
    @NotBlank(message = "Email é obrigatório") @Email(message = "Informe um e-mail válido") String email,
    Endereco endereco)
    {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    // Métodos getters e setters para acessar e modificar os atributos
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo()
    {
        return sexo;
    }

    public void setSexo(Sexo sexo)
    {
        this.sexo = sexo;
    }

    public Setor getSetor()
    {
        return setor;
    }

    public void setSetor(Setor setor)
    {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil()
    {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil)
    {
        this.estadoCivil = estadoCivil;
    }

    public Double getSalario()
    {
        return salario;
    }

    public void setSalario(Double salario)
    {
        this.salario = salario;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Endereco getEndereco()
    {
        return endereco;
    }

    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
    }

    // Método toString para representar o objeto como uma string
    @Override
    public String toString()
    {
        return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento +
        ", sexo=" + sexo + ", setor=" + setor + ", estadoCivil=" + estadoCivil + ", salario=" + salario +
        ", email=" + email + ", endereco=" + endereco + "]";
    }
}
