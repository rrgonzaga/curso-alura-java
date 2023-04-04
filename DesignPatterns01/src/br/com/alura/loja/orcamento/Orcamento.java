package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

public class Orcamento {
    private final BigDecimal valor;
    private final Integer quantidadeItens;

    public Orcamento(BigDecimal valor, Integer quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
    }
    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidadeItens() {
        return quantidadeItens;
    }
}
