package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

public class Orcamento {
    private BigDecimal valor;
    private Integer quantidadeItens;
    private String situacao;

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

    public String getSituacao() {
        return this.situacao;
    }

    public void aplicarDescontoExtra() {
        BigDecimal valorDescExtra = BigDecimal.ZERO;
        if (situacao.equals("EM_ANALISE")) {
            valorDescExtra = new BigDecimal("0.05");
        } else if (situacao.equals("APROVADO")) {
            valorDescExtra = new BigDecimal("0.02");
        }

        this.valor = this.valor.subtract(this.valor.multiply(valorDescExtra));
    }
    public void aprovar() {
        this.situacao = "APROVADO";
    }
}
