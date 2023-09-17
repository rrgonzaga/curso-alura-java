package br.com.alura.loja.orcamento.situacao;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.situacao.exceptions.*;

import java.math.BigDecimal;

public abstract class SituacaoOrcamento {

    public abstract String getDescricao();

    protected BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }
    public void atualizarValorOrcamento(Orcamento orcamento) {
        BigDecimal descontoExtra = calcularValorDescontoExtra(orcamento);

        if (!BigDecimal.ZERO.equals(descontoExtra)) {
            orcamento.setValor(orcamento.getValor().subtract(descontoExtra));
        }
    }
    public void finalizar(Orcamento orcamento) {
        throw new SituacaoNaoPermitidaFinalizarException(getDescricao());
    }

    public void encerrar(Orcamento orcamento) {
        throw new SituacaoNaoPermitidaEncerrarException(getDescricao());
    }
    public void analisar(Orcamento orcamento) {
        throw new SituacaoNaoPermitidaAnalisarException(getDescricao());
    }
    public void aprovar(Orcamento orcamento) {
        throw new SituacaoNaoPermitidaAprovarException(getDescricao());
    }
    public void reprovar(Orcamento orcamento) {
        throw new SituacaoNaoPermitidaReprovarException(getDescricao());
    }
}
