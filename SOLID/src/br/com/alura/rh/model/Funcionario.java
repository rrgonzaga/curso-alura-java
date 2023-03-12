package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private DadosPessoais dadosPessoais;
    private BigDecimal salario;
    private LocalDate dataUltimoReajuste;
    private BeneficioFuncionario beneficio;

    public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        this.dadosPessoais = new DadosPessoais(nome,cpf,cargo);
        this.salario = salario;
    }
    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }
    public BigDecimal getSalario() {
        return salario;
    }
    public LocalDate getDataUltimoReajuste() {
        return dataUltimoReajuste;
    }

    @Override
    public BeneficioFuncionario getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(BeneficioFuncionario beneficio) {
        this.beneficio = beneficio;
    }

    public void atualizarSalario(BigDecimal salarioReajustado) {
        this.salario = salarioReajustado;
        this.dataUltimoReajuste = LocalDate.now();
    }
    public void promover(Cargo novoCargo) {
        this.dadosPessoais.setCargo(novoCargo);
    }
}
