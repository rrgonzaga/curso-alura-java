package br.com.alura.loja.orcamento.situacao.exceptions;

import br.com.alura.loja.enumerations.Situacao;

public class SituacaoNaoPermitidaFinalizarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaFinalizarException(String descricaoSituacaoAtual) {
        super("A situação atual do orçamento: \"" + descricaoSituacaoAtual + "\" não pode ser mudada para \"" + Situacao.FINALIZADO.getDescricao() + "\"");
    }
}
