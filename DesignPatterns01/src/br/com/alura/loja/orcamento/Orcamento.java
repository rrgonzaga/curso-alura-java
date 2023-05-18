package br.com.alura.loja.orcamento;

import br.com.alura.loja.enumerations.Situacao;
import br.com.alura.loja.orcamento.situacao.exceptions.*;

import java.math.BigDecimal;

public class Orcamento {
    private BigDecimal valor;
    private Integer quantidadeItens;
    private Situacao situacao;

    public Orcamento(BigDecimal valor, Integer quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacao = Situacao.EM_ELABORACAO;
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

    public BigDecimal calcularValorDescontoExtra() {
        BigDecimal valorDescExtra = BigDecimal.ZERO;
        if (Situacao.EM_ANALISE.equals(this.situacao)) {
            valorDescExtra = new BigDecimal("0.05");
        } else if (Situacao.APROVADO.equals(this.situacao)) {
            valorDescExtra = new BigDecimal("0.02");
        }

        return this.valor.multiply(valorDescExtra);
    }

    public void atualizarValorOrcamento() {
        this.valor = this.valor.subtract(calcularValorDescontoExtra());
    }
    public void finalizar() {
        if (!Situacao.EM_ELABORACAO.equals(this.situacao)) {
            throw new SituacaoNaoPermitidaFinalizarException(this.situacao.getDescricao());
        }
        this.situacao = Situacao.FINALIZADO;}

    public void encerrar() {
        if (!(Situacao.EM_ELABORACAO.equals(this.situacao) || Situacao.FINALIZADO.equals(this.situacao))) {
            throw new SituacaoNaoPermitidaEncerrarException(this.situacao.getDescricao());
        }
        this.situacao = Situacao.ENCERRADO;
    }
    public void analisar() {
        if (!Situacao.FINALIZADO.equals(this.situacao)) {
            throw new SituacaoNaoPermitidaAnalisarException(this.situacao.getDescricao());
        }
        this.situacao = Situacao.EM_ANALISE;
    }

    public void aprovar() {
        if (!Situacao.EM_ANALISE.equals(this.situacao)) {
            throw new SituacaoNaoPermitidaAprovarException(this.situacao.getDescricao());
        }
        this.situacao = Situacao.APROVADO;
    }

    public void reprovar() {
        if (!Situacao.EM_ANALISE.equals(this.situacao)) {
            throw new SituacaoNaoPermitidaReprovarException(this.situacao.getDescricao());
        }
        this.situacao = Situacao.REPROVADO;
    }
}
