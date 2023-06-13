package br.com.alura.loja.orcamento.situacao.exceptions;

import br.com.alura.loja.enumerations.Situacao;

public class SituacaoNaoPermitidaEncerrarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaEncerrarException(String descricaoSituacaoAtual) {
        super("A situação atual do orçamento: \"" + descricaoSituacaoAtual + "\" não pode ser mudada para \"" + Situacao.ENCERRADO.getDescricao() + "\"");
    }
}
