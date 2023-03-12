package br.com.alura.rh.model;

import java.math.BigDecimal;

public class BeneficioFuncionario extends Beneficio{
    private BigDecimal valorPLR;
    private BigDecimal bonificacaoMetaSuperada;

    public BeneficioFuncionario(BigDecimal valeRefeicao, BigDecimal valeTransporte, PlanoSaude planoSaude) {
        super(valeRefeicao, valeTransporte, planoSaude);
    }

    public BigDecimal getValorPLR() {
        return valorPLR;
    }

    public void setValorPLR(BigDecimal valorPLR) {
        this.valorPLR = valorPLR;
    }

    public BigDecimal getBonificacaoMetaSuperada() {
        return bonificacaoMetaSuperada;
    }

    public void setBonificacaoMetaSuperada(BigDecimal bonificacaoMetaSuperada) {
        this.bonificacaoMetaSuperada = bonificacaoMetaSuperada;
    }
}
