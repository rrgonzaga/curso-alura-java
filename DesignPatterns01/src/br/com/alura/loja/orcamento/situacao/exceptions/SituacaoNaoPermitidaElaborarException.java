package br.com.alura.loja.orcamento.situacao.exceptions;

import br.com.alura.loja.enumerations.Situacao;

public class SituacaoNaoPermitidaElaborarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaElaborarException(String descricaoSituacaoAtual) {
        super("A situação atual do orçamento: \"" + descricaoSituacaoAtual + "\" não pode ser mudada para \"" + Situacao.EM_ELABORACAO.getDescricao() + "\"");
    }
}
