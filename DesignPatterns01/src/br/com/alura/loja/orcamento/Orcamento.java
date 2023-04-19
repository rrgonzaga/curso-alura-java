package br.com.alura.loja.orcamento;

import br.com.alura.loja.enumerations.Situacao;

import java.math.BigDecimal;

public class Orcamento {
    private BigDecimal valor;
    private Integer quantidadeItens;
    private Situacao situacao;

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

    public Situacao getSituacao() {
        return this.situacao;
    }
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    public void aplicarDescontoExtra() {
        BigDecimal valorDescExtra = BigDecimal.ZERO;
        if (Situacao.EM_ANALISE.equals(this.situacao)) {
            valorDescExtra = new BigDecimal("0.05");
        } else if (Situacao.APROVADO.equals(this.situacao)) {
            valorDescExtra = new BigDecimal("0.02");
        }

        this.valor = this.valor.subtract(this.valor.multiply(valorDescExtra));
    }
    public void aprovar() {
        this.situacao = Situacao.APROVADO;
    }
}
