package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.*;

import java.math.BigDecimal;

public class Orcamento {
    private BigDecimal valor;
    private Integer quantidadeItens;
    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, Integer quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacao = new EmElaboracao();
    }
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeItens() {
        return quantidadeItens;
    }

    public SituacaoOrcamento getSituacao() {
        return this.situacao;
    }
    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public boolean isAprovado() {
        return this.situacao instanceof Aprovado;
    }
}
