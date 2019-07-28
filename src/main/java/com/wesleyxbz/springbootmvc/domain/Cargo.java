package com.wesleyxbz.springbootmvc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long> {

    @NotBlank(message = "O nome do cargo é obrigatório.")
    @Size(max = 60, message = "O nome do cargo deve contér no máximo {max} caracteres.")
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    @NotNull(message = "Selecione o departamento relativo ao cargo")
    @ManyToOne                                                            // Lado forte da relação, lado N x 1
    @JoinColumn(name = "id_departamento_fk")                            // Coluna no banco
    private Departamento departamento;

    @OneToMany(mappedBy = "cargo")                                        // Lado fraco da tabela, lado 1
    private List<Funcionario> funcionarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim(); // "trim" = remove espaços em branco da string
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
