package br.com.alura.rh.model;

import java.time.LocalDate;

public class Terceirizado {
    private DadosPessoais dadosPessoais;
    private String empresa;
    private LocalDate dataInicioContrato;
    private LocalDate dataRenovacaoContrato;

    public Terceirizado(String nome, String cpf, Cargo cargo, String empresa) {
        this.dadosPessoais = new DadosPessoais(nome, cpf, cargo);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public LocalDate getDataInicioContrato() {
        return dataInicioContrato;
    }

    public void setDataInicioContrato(LocalDate dataInicioContrato) {
        this.dataInicioContrato = dataInicioContrato;
    }

    public LocalDate getDataRenovacaoContrato() {
        return dataRenovacaoContrato;
    }

    public void setDataRenovacaoContrato(LocalDate dataRenovacaoContrato) {
        this.dataRenovacaoContrato = dataRenovacaoContrato;
    }
}
