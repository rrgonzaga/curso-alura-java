package br.com.alura.loja.orcamento.situacao.exceptions;

import br.com.alura.loja.enumerations.Situacao;

public class SituacaoNaoPermitidaAnalisarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaAnalisarException(String descricaoSituacaoAtual) {
        super("A situação atual do orçamento: \"" + descricaoSituacaoAtual + "\" não pode ser mudada para \"" + Situacao.EM_ANALISE.getDescricao() + "\"");
    }
}
