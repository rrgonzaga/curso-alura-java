package br.com.alura.loja.orcamento.situacao.exceptions;

public class SituacaoNaoPermitidaAnalisarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaAnalisarException(String descricaoSituacao) {
        super("Situação do orçamento: \"" + descricaoSituacao + "\" não permitida para analisar");
    }
}
