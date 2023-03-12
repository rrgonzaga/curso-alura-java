package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Estagiario extends Pessoa {
    private DadosPessoais dadosPessoais;
    private BigDecimal salario;
    private String nomeInstituicaoEnsino;
    private LocalDate dataInicioEstagio;
    private LocalDate dataFimEstagio;

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getNomeInstituicaoEnsino() {
        return nomeInstituicaoEnsino;
    }

    public void setNomeInstituicaoEnsino(String nomeInstituicaoEnsino) {
        this.nomeInstituicaoEnsino = nomeInstituicaoEnsino;
    }

    public LocalDate getDataInicioEstagio() {
        return dataInicioEstagio;
    }

    public void setDataInicioEstagio(LocalDate dataInicioEstagio) {
        this.dataInicioEstagio = dataInicioEstagio;
    }

    public LocalDate getDataFimEstagio() {
        return dataFimEstagio;
    }

    public void setDataFimEstagio(LocalDate dataFimEstagio) {
        this.dataFimEstagio = dataFimEstagio;
    }
}
