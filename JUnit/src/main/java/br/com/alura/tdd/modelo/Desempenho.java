package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR(new BigDecimal("0.03")),
    BOM(new BigDecimal("0.15")),
    OTIMO (new BigDecimal("0.20"));

    private BigDecimal percentualReajuste;

    Desempenho(BigDecimal percentualReajuste) {
        this.percentualReajuste = percentualReajuste;
    }
    public BigDecimal getPercentualReajuste() {
        return this.percentualReajuste;
    }
}
