package br.com.alura.rh.model;

import java.math.BigDecimal;

public class BeneficioEstagiario extends Beneficio{

    private BigDecimal bolsaEstagio;

    public BeneficioEstagiario(BigDecimal valeRefeicao, BigDecimal valeTransporte, PlanoSaude planoSaude) {
        super(valeRefeicao, valeTransporte, planoSaude);
    }

    public BeneficioEstagiario(BigDecimal valeRefeicao, BigDecimal valeTransporte, PlanoSaude planoSaude, BigDecimal bolsaEstagio) {
        this(valeRefeicao, valeTransporte, planoSaude);
        this.bolsaEstagio = bolsaEstagio;
    }

    public BigDecimal getBolsaEstagio() {
        return bolsaEstagio;
    }
}
