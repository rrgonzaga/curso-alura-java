package br.com.alura.loja.orcamento.situacao.exceptions;

public class SituacaoNaoPermitidaFinalizarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaFinalizarException(String descricaoSituacao) {
        super("Situação do orçamento: \"" + descricaoSituacao + "\" não permitida para finalizar");
    }
}
