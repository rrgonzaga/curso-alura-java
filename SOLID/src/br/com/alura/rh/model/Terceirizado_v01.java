package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Terceirizado_v01 extends Funcionario {
    private String empresa;
    private LocalDate dataInicioContrato;
    private LocalDate dataRenovacaoContrato;

    public Terceirizado_v01(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        super(nome, cpf, cargo, null);
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
